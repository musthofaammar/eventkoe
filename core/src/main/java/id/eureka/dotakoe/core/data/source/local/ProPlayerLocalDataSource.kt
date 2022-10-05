package id.eureka.dotakoe.core.data.source.local

import id.eureka.dotakoe.core.data.source.local.entity.ProPlayerEntity
import id.eureka.dotakoe.core.data.source.local.room.ProPlayerDao
import kotlinx.coroutines.flow.Flow

class ProPlayerLocalDataSource(private val proPlayerDao: ProPlayerDao) {

    fun getAllProPlayers(): Flow<List<ProPlayerEntity>> = proPlayerDao.getAllProPlayer()

    suspend fun insertProPlayer(proPlayers: List<ProPlayerEntity>) =
        proPlayerDao.insertProPlayers(proPlayers)

    suspend fun setFavorite(proPlayer: ProPlayerEntity, newState: Boolean) {
        proPlayer.favorite = newState
        proPlayerDao.updateProPlayerFavorite(proPlayer.accountId, newState)
    }

    fun getFavoriteProPlayer() = proPlayerDao.getFavoriteProPlayer()

}