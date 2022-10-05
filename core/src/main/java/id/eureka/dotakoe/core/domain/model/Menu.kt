package id.eureka.dotakoe.core.domain.model

data class Menu(
    val title: String,
    val backdrop: String,
    val menuType: MenuType
)

enum class MenuType {
    TEAMS, PLAYERS, HEROES
}