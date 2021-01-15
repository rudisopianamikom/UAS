package com.example.uas_clientserver_17620107.common.domain.model

import com.squareup.moshi.Json

data class TeamDetail (
        @Json(name = "teams") val teams : List<TeamNameDetail>
)

data class TeamNameDetail (
        @Json(name = "strTeamBadge") val strTeamBadge : String
)