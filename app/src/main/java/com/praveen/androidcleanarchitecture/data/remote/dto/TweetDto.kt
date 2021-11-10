package com.praveen.androidcleanarchitecture.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.praveen.androidcleanarchitecture.domain.model.Tweet

data class TweetDto(
    @SerializedName("date")
    val date: String?,
    @SerializedName("is_retweet")
    val isRetweet: Boolean?,
    @SerializedName("like_count")
    val likeCount: Int,
    @SerializedName("media_link")
    val mediaLink: String?,
    @SerializedName("retweet_count")
    val retweetCount: Int,
    @SerializedName("status")
    val status: String?,
    @SerializedName("status_id")
    val statusId: String?,
    @SerializedName("status_link")
    val statusLink: String?,
    @SerializedName("user_image_link")
    val userImageLink: String?,
    @SerializedName("user_name")
    val userName: String?,
    @SerializedName("youtube_link")
    val youtubeLink: String?
)

fun TweetDto.toTweet(): Tweet {
    return Tweet(
        date = date,
        isRetweet = isRetweet ?: false,
        likeCount = likeCount,
        mediaLink = mediaLink,
        retweetCount = retweetCount,
        status = status,
        statusId = statusId,
        statusLink= statusLink,
        userImageLink = userImageLink,
        userName = userName,
        youtubeLink = youtubeLink
    )
}
