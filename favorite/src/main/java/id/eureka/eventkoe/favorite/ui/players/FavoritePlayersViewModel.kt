package id.eureka.eventkoe.favorite.ui.players

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.eureka.dotakoe.core.domain.usecase.ProPlayerUseCase

class FavoritePlayersViewModel(private val userCase: ProPlayerUseCase) : ViewModel() {
    fun getFavoriteProPlayer() = userCase.getFavoriteProPlayer().asLiveData()
}