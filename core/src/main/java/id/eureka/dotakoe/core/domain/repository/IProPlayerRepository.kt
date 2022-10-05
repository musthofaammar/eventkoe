package id.eureka.dotakoe.core.domain.repository

import id.eureka.dotakoe.core.data.source.Resource
import id.eureka.dotakoe.core.data.source.local.entity.ProPlayerEntity
import id.eureka.dotakoe.core.domain.model.ProPlayer
import kotlinx.coroutines.flow.Flow

interface IProPlayerRepository {

    fun getAllProPlayers(): Flow<Resource<List<ProPlayer>>>
    fun getProPlayerDetail(accountId: String): Flow<Resource<ProPlayer>>
    fun getFavoriteProPlayer(): Flow<List<ProPlayer>>
    fun setProPlayerFavorite(proPlayer: ProPlayer, newState : Boolean)

}