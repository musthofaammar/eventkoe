package id.eureka.eventkoe.ui.players

import androidx.lifecycle.ViewModel
import id.eureka.dotakoe.core.domain.model.ProPlayer
import id.eureka.dotakoe.core.domain.usecase.ProPlayerUseCase

class PlayerDetailViewModel(private val useCase: ProPlayerUseCase) : ViewModel() {



    fun getPlayerTeamDetail() = useCase.getAllProPlayer()
    fun setFavorite(proPlayer: ProPlayer, newState: Boolean) =
        useCase.setProPlayerFavorite(proPlayer, newState)
}