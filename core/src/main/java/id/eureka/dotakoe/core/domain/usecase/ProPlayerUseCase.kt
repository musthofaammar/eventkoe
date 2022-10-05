package id.eureka.dotakoe.core.domain.usecase

import id.eureka.dotakoe.core.data.source.Resource
import id.eureka.dotakoe.core.domain.model.ProPlayer
import kotlinx.coroutines.flow.Flow

interface ProPlayerUseCase {
    fun getAllProPlayer(): Flow<Resource<List<ProPlayer>>>
    fun getFavoriteProPlayer(): Flow<List<ProPlayer>>
    fun setProPlayerFavorite(proPlayer: ProPlayer, newState : Boolean)
}