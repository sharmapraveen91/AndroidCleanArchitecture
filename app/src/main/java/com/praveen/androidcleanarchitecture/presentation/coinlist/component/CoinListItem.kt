package com.praveen.androidcleanarchitecture.presentation.coinlist.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.praveen.androidcleanarchitecture.common.Constant
import com.praveen.androidcleanarchitecture.domain.model.Coin

@Composable
fun CoinListItem(coin: Coin, onItemClick: (Coin) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${coin.rank} ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = if (coin.isActive) Constant.ACTIVE else Constant.IN_ACTIVE,
            color = if (coin.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)
        )
    }
}