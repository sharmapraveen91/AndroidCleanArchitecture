package com.praveen.androidcleanarchitecture.domain.use_case.get_tweets

import com.praveen.androidcleanarchitecture.common.Resource
import com.praveen.androidcleanarchitecture.data.remote.dto.toTweet
import com.praveen.androidcleanarchitecture.domain.model.Tweet
import com.praveen.androidcleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinTweetsUseCase @Inject constructor(private val repository: CoinRepository) {

        operator fun invoke(coinId: String): Flow<Resource<List<Tweet>>> = flow {
            try {
                emit(Resource.Loading<List<Tweet>>())
                val tweets = repository.getCoinTweetsById(coinId).map {  it.toTweet() }
                emit(Resource.Success<List<Tweet>>(tweets))
            } catch (e: HttpException) {
                emit(Resource.Error<List<Tweet>>(message = e.localizedMessage ?: "Error Occurred"))
            } catch (e: IOException) {
                emit(Resource.Error<List<Tweet>>(e.localizedMessage ?: "Network Error Occurred"))
            }
        }

    }