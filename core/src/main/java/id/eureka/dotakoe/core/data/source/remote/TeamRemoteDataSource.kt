package id.eureka.dotakoe.core.data.source.remote

import id.eureka.dotakoe.core.data.source.remote.network.ApiResponse
import id.eureka.dotakoe.core.data.source.remote.network.ApiService
import id.eureka.dotakoe.core.data.source.remote.response.TeamResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TeamRemoteDataSource(private val apiService: ApiService) {

    fun getTeamById(teamId: String): Flow<ApiResponse<List<TeamResponse>>> {
        return flow {
            try {
                val response = apiService.getTeamByID(teamId)
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}