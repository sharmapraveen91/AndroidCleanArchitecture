package com.praveen.androidcleanarchitecture.domain.use_case.get_coins

import com.praveen.androidcleanarchitecture.common.Resource
import com.praveen.androidcleanarchitecture.data.remote.dto.toCoin
import com.praveen.androidcleanarchitecture.domain.model.Coin
import com.praveen.androidcleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Network Error Occurred"))
        }
    }
}
