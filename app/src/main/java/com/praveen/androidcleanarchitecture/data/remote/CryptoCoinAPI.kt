package com.praveen.androidcleanarchitecture.data.remote

import com.praveen.androidcleanarchitecture.data.remote.dto.CoinDetailDto
import com.praveen.androidcleanarchitecture.data.remote.dto.CoinDto
import com.praveen.androidcleanarchitecture.data.remote.dto.TweetDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoCoinAPI {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

    @GET("/v1/coins/{coinId}/twitter")
    suspend fun getCoinTweets(@Path("coinId") coinId: String): List<TweetDto>
}