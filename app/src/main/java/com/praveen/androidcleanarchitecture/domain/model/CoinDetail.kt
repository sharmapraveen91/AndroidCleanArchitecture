package com.praveen.androidcleanarchitecture.domain.model

import com.praveen.androidcleanarchitecture.data.remote.dto.TeamMember

data class CoinDetail(
    val id: String,
    val description: String?,
    val name: String?,
    val isActive: Boolean,
    val rank: Int,
    val tags: List<String>?,
    val team: List<TeamMember>?,
    val symbol: String?
)
