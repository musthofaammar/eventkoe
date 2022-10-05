package id.eureka.dotakoe.core.domain.usecase

import id.eureka.dotakoe.core.data.source.Resource
import id.eureka.dotakoe.core.domain.model.ProPlayer
import id.eureka.dotakoe.core.domain.repository.IProPlayerRepository
import kotlinx.coroutines.flow.Flow

class ProPlayerIteractor(private val proPlayerRepository: IProPlayerRepository) : ProPlayerUseCase {

    override fun getAllProPlayer(): Flow<Resource<List<ProPlayer>>> =
        proPlayerRepository.getAllProPlayers()

    override fun getFavoriteProPlayer(): Flow<List<ProPlayer>> =
        proPlayerRepository.getFavoriteProPlayer()

    override fun setProPlayerFavorite(proPlayer: ProPlayer, newState: Boolean) {
        proPlayerRepository.setProPlayerFavorite(proPlayer, newState)
    }


}