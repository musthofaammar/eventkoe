package id.eureka.dotakoe.core.data.source.remote.network

import id.eureka.dotakoe.core.data.source.remote.response.ProPlayerResponse
import id.eureka.dotakoe.core.data.source.remote.response.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("proPlayers")
    suspend fun getProPlayers(): List<ProPlayerResponse>

    @GET("teams")
    suspend fun getAllTeams(): List<TeamResponse>

    @GET("teams/{team_id}")
    suspend fun getTeamByID(@Path("team_id") teamId: String): List<TeamResponse>
}