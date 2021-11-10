package com.praveen.androidcleanarchitecture.presentation.coinlist

import com.praveen.androidcleanarchitecture.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String =""
)
