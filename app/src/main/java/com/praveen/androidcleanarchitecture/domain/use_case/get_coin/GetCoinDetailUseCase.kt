package com.praveen.androidcleanarchitecture.domain.use_case.get_coin

import com.praveen.androidcleanarchitecture.common.Resource
import com.praveen.androidcleanarchitecture.data.remote.dto.toCoinDetail
import com.praveen.androidcleanarchitecture.domain.model.CoinDetail
import com.praveen.androidcleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(message = e.localizedMessage ?: "Error Occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Network Error Occurred"))
        }
    }

}