package id.eureka.eventkoe.ui.players

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.eureka.dotakoe.core.domain.usecase.ProPlayerUseCase

class PlayersViewModel(private val useCase: ProPlayerUseCase) : ViewModel() {

    fun getAllProPlayer() = useCase.getAllProPlayer().asLiveData()

}