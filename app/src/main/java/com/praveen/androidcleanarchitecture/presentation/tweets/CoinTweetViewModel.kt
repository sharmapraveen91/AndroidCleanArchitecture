package com.praveen.androidcleanarchitecture.presentation.tweets

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.praveen.androidcleanarchitecture.common.Constant
import com.praveen.androidcleanarchitecture.common.Resource
import com.praveen.androidcleanarchitecture.domain.use_case.get_tweets.GetCoinTweetsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinTweetViewModel @Inject constructor(
    private val getCoinTweetsUseCase: GetCoinTweetsUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    private val _state = mutableStateOf(CoinTweetState())
    val state: State<CoinTweetState> = _state

    init {
        savedStateHandle.get<String>(Constant.PARAM_COIN_ID)
            ?.let { coinId -> getTweets(coinId) }
    }

    private fun getTweets(coinId: String) {
        getCoinTweetsUseCase(coinId = coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinTweetState(tweets = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinTweetState(error = result.message ?: "Error Occurred")
                }
                is Resource.Loading -> {
                    _state.value = CoinTweetState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}