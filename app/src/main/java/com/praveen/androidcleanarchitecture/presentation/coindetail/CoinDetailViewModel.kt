package com.praveen.androidcleanarchitecture.presentation.coindetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.praveen.androidcleanarchitecture.common.Constant
import com.praveen.androidcleanarchitecture.common.Resource
import com.praveen.androidcleanarchitecture.domain.use_case.get_coin.GetCoinDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinDetailUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constant.PARAM_COIN_ID)
            ?.let { coinId -> getCoinDetail(coinId) }

    }

    private fun getCoinDetail(coinId: String) {
        getCoinUseCase(coinId = coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coinDetail = result.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(error = result.message ?: "Error Occurred")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}