package com.praveen.androidcleanarchitecture.presentation.tweets.component

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Replay
import androidx.compose.material.icons.outlined.Reply
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.praveen.androidcleanarchitecture.domain.model.Tweet
import com.praveen.androidcleanarchitecture.presentation.component.SeparatorDivider
import com.praveen.androidcleanarchitecture.presentation.component.SeparatorSpacer

@Composable
fun TweetComponent(tweets: Tweet) {
    Column(
        modifier = Modifier
            .padding(
                top = 10.dp,
                start = 10.dp,
                end = 10.dp
            )
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Log.d("Tweets","user image link ${tweets.userImageLink}")
            // coil-compose
            Image(
                painter = rememberImagePainter(
                    data = tweets.userImageLink,
                    builder = {
                        crossfade(true)
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = "user",
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
            )
            SeparatorSpacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    tweets.userName.let {
                        Text(
                            text = tweets.userName ?: "",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )

                        SeparatorSpacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = tweets.timeAgo(),
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        )
                    }
                }
                if (!tweets.status.isNullOrBlank()) {
                    SeparatorSpacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = tweets.status,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp
                    )
                }
                if (tweets.mediaLink != null) {
                    SeparatorSpacer(modifier = Modifier.height(8.dp))
                    Image(
                        painter = rememberImagePainter(
                            data = tweets.mediaLink,
                        ),
                        contentScale = ContentScale.FillWidth,
                        contentDescription = "tweet",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                    )
                }
                SeparatorSpacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TweetOptions(
                        icon = Icons.Outlined.Reply,
                        count = "0"
                    )
                    TweetOptions(
                        icon = Icons.Outlined.Replay,
                        count = tweets.retweetCount.toString()
                    )
                    TweetOptions(
                        icon = Icons.Outlined.Star,
                        count = tweets.likeCount.toString()
                    )
                    TweetOptions(
                        icon = Icons.Outlined.Share,
                        count = null
                    )
                }
            }
        }
        SeparatorDivider()
    }
}

@Composable
fun TweetOptions(icon: ImageVector, count: String?) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            modifier = Modifier,
            contentDescription = "icon"
        )
        SeparatorSpacer(modifier = Modifier.width(5.dp))
        if (count != null) {
            Text(
                text = count,
                maxLines = 1,
                fontSize = 14.sp,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}