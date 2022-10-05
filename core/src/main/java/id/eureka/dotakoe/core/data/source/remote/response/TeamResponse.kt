package id.eureka.dotakoe.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TeamResponse(

    @field:SerializedName("wins")
    val wins: Int,

    @field:SerializedName("last_match_time")
    val lastMatchTime: Int,

    @field:SerializedName("logo_url")
    val logoUrl: String,

    @field:SerializedName("rating")
    val rating: Double,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("team_id")
    val teamId: Int,

    @field:SerializedName("tag")
    val tag: String,

    @field:SerializedName("losses")
    val losses: Int
)
