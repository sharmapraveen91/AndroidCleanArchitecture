package com.praveen.androidcleanarchitecture.data.repository

import com.praveen.androidcleanarchitecture.data.remote.CryptoCoinAPI
import com.praveen.androidcleanarchitecture.data.remote.dto.CoinDetailDto
import com.praveen.androidcleanarchitecture.data.remote.dto.CoinDto
import com.praveen.androidcleanarchitecture.data.remote.dto.TweetDto
import com.praveen.androidcleanarchitecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CryptoCoinAPI): CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
      return  api.getCoins()
    }

    override suspend fun getCoinById(id: String): CoinDetailDto {
      return api.getCoinById(id)
    }

    override suspend fun getCoinTweetsById(id: String): List<TweetDto> {
        return api.getCoinTweets(id)
    }
}