package id.eureka.dotakoe.core.data.source.remote

import id.eureka.dotakoe.core.data.source.remote.network.ApiResponse
import id.eureka.dotakoe.core.data.source.remote.network.ApiService
import id.eureka.dotakoe.core.data.source.remote.response.ProPlayerResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ProPlayerRemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllProPlayers(): Flow<ApiResponse<List<ProPlayerResponse>>> {
        return flow {
            try {
                val response = apiService.getProPlayers()
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