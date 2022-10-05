package id.eureka.dotakoe.core.utils

import id.eureka.dotakoe.core.domain.model.Menu
import id.eureka.dotakoe.core.domain.model.MenuType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

object MenuGenerator {

    suspend fun generateMenu(): Flow<List<Menu>> {
        return flow {
            val menus = mutableListOf<Menu>()
            menus.add(Menu("Teams", "https://wallpapercave.com/wp/d7UPA59.jpg", MenuType.TEAMS))
            menus.add(Menu("Players", "https://wallpapercave.com/wp/d7UPA59.jpg", MenuType.PLAYERS))
            menus.add(Menu("Heroes", "https://wallpapercave.com/wp/d7UPA59.jpg", MenuType.HEROES))
            emit(menus)
        }.flowOn(Dispatchers.IO)
    }
}