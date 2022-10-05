package id.eureka.eventkoe.di

import id.eureka.dotakoe.core.domain.usecase.ProPlayerIteractor
import id.eureka.dotakoe.core.domain.usecase.ProPlayerUseCase
import id.eureka.eventkoe.ui.players.PlayerDetailViewModel
import id.eureka.eventkoe.ui.players.PlayersViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<ProPlayerUseCase> { ProPlayerIteractor(get()) }
}

val viewModelModule = module {
    viewModel { PlayersViewModel(get()) }
    viewModel { PlayerDetailViewModel(get()) }
}