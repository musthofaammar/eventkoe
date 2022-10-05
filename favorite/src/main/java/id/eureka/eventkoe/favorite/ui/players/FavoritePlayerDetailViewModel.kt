package id.eureka.eventkoe.favorite.ui.players

import androidx.lifecycle.ViewModel
import id.eureka.dotakoe.core.domain.model.ProPlayer
import id.eureka.dotakoe.core.domain.usecase.ProPlayerUseCase

class FavoritePlayerDetailViewModel(private val useCase: ProPlayerUseCase) : ViewModel() {

    fun setFavorite(proPlayer: ProPlayer, newState: Boolean) =
        useCase.setProPlayerFavorite(proPlayer, newState)

}