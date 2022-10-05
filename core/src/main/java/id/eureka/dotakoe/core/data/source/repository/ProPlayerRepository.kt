package id.eureka.dotakoe.core.data.source.repository

import id.eureka.dotakoe.core.data.source.NetworkBoundResource
import id.eureka.dotakoe.core.data.source.Resource
import id.eureka.dotakoe.core.data.source.local.ProPlayerLocalDataSource
import id.eureka.dotakoe.core.data.source.remote.ProPlayerRemoteDataSource
import id.eureka.dotakoe.core.data.source.remote.network.ApiResponse
import id.eureka.dotakoe.core.data.source.remote.response.ProPlayerResponse
import id.eureka.dotakoe.core.domain.model.ProPlayer
import id.eureka.dotakoe.core.domain.repository.IProPlayerRepository
import id.eureka.dotakoe.core.utils.DataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ProPlayerRepository(
    val proPlayerLocalDataSource: ProPlayerLocalDataSource,
    val proPlayerRemoteDataSource: ProPlayerRemoteDataSource
) :
    IProPlayerRepository {
    override fun getAllProPlayers(): Flow<Resource<List<ProPlayer>>> {
        return object : NetworkBoundResource<List<ProPlayer>, List<ProPlayerResponse>>() {
            override fun loadFromDB(): Flow<List<ProPlayer>> {
                return proPlayerLocalDataSource.getAllProPlayers().map {
                    DataMapper.mapProPlayerEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<ProPlayer>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<ProPlayerResponse>>> =
                proPlayerRemoteDataSource.getAllProPlayers()

            override suspend fun saveCallResult(data: List<ProPlayerResponse>) {
                val proPlayers = DataMapper.mapProPlayerResponseToEntities(data)
                proPlayerLocalDataSource.insertProPlayer(proPlayers)
            }

        }.asFlow()
    }

    override fun getProPlayerDetail(accountId: String): Flow<Resource<ProPlayer>> {
        TODO("Not yet implemented")
    }

    override fun getFavoriteProPlayer(): Flow<List<ProPlayer>> {
        return proPlayerLocalDataSource.getFavoriteProPlayer().map {
            DataMapper.mapProPlayerEntitiesToDomain(it)
        }
    }

    override fun setProPlayerFavorite(proPlayer: ProPlayer, newState: Boolean) {
        val proPlayerEntity = DataMapper.mapPlayerDomainToEntity(proPlayer)
        GlobalScope.launch(Dispatchers.IO){
            proPlayerLocalDataSource.setFavorite(proPlayerEntity, newState)
        }
    }

}