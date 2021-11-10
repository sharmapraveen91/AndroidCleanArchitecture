package com.praveen.androidcleanarchitecture.presentation.tweets

import com.praveen.androidcleanarchitecture.domain.model.Tweet

data class CoinTweetState(
    val isLoading: Boolean = false,
    val tweets: List<Tweet> = emptyList(),
    val error: String = ""
)