package com.praveen.androidcleanarchitecture.data.di

import com.praveen.androidcleanarchitecture.common.Constant
import com.praveen.androidcleanarchitecture.data.remote.CryptoCoinAPI
import com.praveen.androidcleanarchitecture.data.repository.CoinRepositoryImpl
import com.praveen.androidcleanarchitecture.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.OkHttpClient


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CryptoCoinAPI {
        val logging = HttpLoggingInterceptor()
        // set your desired log level
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val httpClient = OkHttpClient.Builder()
        // add your other interceptors …

        // add logging as last interceptor
        // add your other interceptors …

        // add logging as last interceptor
        httpClient.addInterceptor(logging) // <-- this is the important line!

        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(CryptoCoinAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CryptoCoinAPI): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}