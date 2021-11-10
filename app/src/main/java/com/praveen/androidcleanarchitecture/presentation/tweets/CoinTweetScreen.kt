package com.praveen.androidcleanarchitecture.presentation.tweets


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.praveen.androidcleanarchitecture.presentation.tweets.component.TweetComponent

@Composable
fun CoinTweetScreen(
    viewModel: CoinTweetViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp)
    ) {
        items(state.tweets) { tweets ->
            TweetComponent(tweets = tweets)
        }
    }

    if (state.error.isNotBlank()) {
        Text(
            text = state.error,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
    }
    if (state.isLoading) {
        CircularProgressIndicator(modifier = Modifier)
    }

}