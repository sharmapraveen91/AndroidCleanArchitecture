package com.praveen.androidcleanarchitecture.presentation

sealed class Screen(val route: String) {
    object CoinListScreen : Screen("coin_list_screen")
    object CoinDetailScreen : Screen("coin_detail_screen")
    object CoinTweetsScreen : Screen("coin_tweets_screen")
}