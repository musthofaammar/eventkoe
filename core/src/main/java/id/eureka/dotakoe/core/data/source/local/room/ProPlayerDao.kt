package id.eureka.dotakoe.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.eureka.dotakoe.core.data.source.local.entity.ProPlayerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProPlayerDao {

    @Query("SELECT * FROM proPlayer")
    fun getAllProPlayer(): Flow<List<ProPlayerEntity>>

    @Query("SELECT * FROM proPlayer where favorite = 1")
    fun getFavoriteProPlayer(): Flow<List<ProPlayerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProPlayers(proPlayers: List<ProPlayerEntity>)

    @Query("UPDATE proPlayer set favorite = :newState  where accountId = :proPlayerId")
    fun updateProPlayerFavorite(proPlayerId: Int, newState: Boolean): Int
}