package id.eureka.eventkoe.favorite.di

import id.eureka.eventkoe.favorite.ui.players.FavoritePlayerDetailViewModel
import id.eureka.eventkoe.favorite.ui.players.FavoritePlayersViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val favoriteModule: Module = module {
    viewModel { FavoritePlayersViewModel(get()) }
    viewModel { FavoritePlayerDetailViewModel(get()) }
}