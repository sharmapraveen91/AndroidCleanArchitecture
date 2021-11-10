package com.praveen.androidcleanarchitecture.domain.repository

import com.praveen.androidcleanarchitecture.data.remote.dto.CoinDetailDto
import com.praveen.androidcleanarchitecture.data.remote.dto.CoinDto
import com.praveen.androidcleanarchitecture.data.remote.dto.TweetDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(id: String): CoinDetailDto

    suspend fun getCoinTweetsById(id: String): List<TweetDto>
}