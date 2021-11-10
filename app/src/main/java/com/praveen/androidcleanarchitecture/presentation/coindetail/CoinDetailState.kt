package com.praveen.androidcleanarchitecture.presentation.coindetail

import com.praveen.androidcleanarchitecture.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String = ""
)