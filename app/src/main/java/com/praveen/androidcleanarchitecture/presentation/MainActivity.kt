package com.praveen.androidcleanarchitecture.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.praveen.androidcleanarchitecture.presentation.coindetail.CoinDetailScreen
import com.praveen.androidcleanarchitecture.presentation.coinlist.CoinListScreen
import com.praveen.androidcleanarchitecture.presentation.tweets.CoinTweetScreen
import com.praveen.androidcleanarchitecture.presentation.ui.theme.AndroidCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinTweetsScreen.route + "/{coinId}"
                        ) {
                            CoinTweetScreen()
                        }
                        /*composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}"
                        ) {
                            CoinDetailScreen()
                        }*/
                    }
                }
            }
        }
    }
}


