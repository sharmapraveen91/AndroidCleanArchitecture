package com.praveen.androidcleanarchitecture.domain.model

import java.text.SimpleDateFormat
import java.util.*

data class Tweet(
    val date: String?,
    val isRetweet: Boolean,
    val likeCount: Int?,
    val mediaLink: String?,
    val retweetCount: Int?,
    val status: String?,
    val statusId: String?,
    val statusLink: String?,
    val userImageLink: String?,
    val userName: String?,
    val youtubeLink: String?
) {
    fun timeAgo(): String {
//2021-10-27T10:55:48Z
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        sdf.timeZone = TimeZone.getTimeZone("GMT")
        val dateObj: Date = sdf.parse(date)
        val currentTime = Date().time;
        val timeDiff = currentTime - dateObj.time;
        when {
            timeDiff >= (1000 * 60 * 60 * 24) -> {
                // Days
                return "${timeDiff / (1000 * 60 * 60 * 24)}d";
            }
            timeDiff >= (1000 * 60 * 60) -> {
                // Hours
                return "${timeDiff / (1000 * 60 * 60)}h";
            }
            timeDiff >= (1000 * 60) -> {
                // Minutes
                return "${timeDiff / (1000 * 60)}m";
            }
            timeDiff >= 1000 -> {
                // Seconds
                return "${timeDiff / 1000}s";
            }
            else -> return "0s"
        }
    }
}