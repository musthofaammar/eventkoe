package id.eureka.dotakoe.core.utils

import id.eureka.dotakoe.core.data.source.local.entity.ProPlayerEntity
import id.eureka.dotakoe.core.data.source.remote.response.ProPlayerResponse
import id.eureka.dotakoe.core.domain.model.ProPlayer

object DataMapper {
    fun mapProPlayerResponseToEntities(input: List<ProPlayerResponse>): List<ProPlayerEntity> {
        val proPlayers = mutableListOf<ProPlayerEntity>()
        input.map { item ->
            val proPlayerEntity = ProPlayerEntity(
                accountId = item.accountId ?: 1,
                avatar = item.avatar ?: "",
                avatarMedium = item.avatarmedium ?: "",
                avatarFull = item.avatarfull ?: "",
                cheese = item.cheese ?: 0,
                countryCode = item.countryCode ?: "",
                fantasyRole = item.fantasyRole ?: 0,
                fh_unavailable = item.fhUnavailable ?: false,
                fullHistoryTime = item.fullHistoryTime ?: "",
                isLocked = item.isLocked ?: false,
                isPro = item.isPro ?: false,
                lastLogin = item.lastLogin ?: "",
                lastMatchTime = item.lastMatchTime ?: "",
                locCountryCode = item.loccountrycode ?: "",
                lockedUntil = item.lockedUntil ?: "",
                name = item.name ?: "",
                personName = item.personaname ?: "",
                plus = item.plus ?: false,
                profileUrl = item.profileurl ?: "",
                steamId = item.steamid ?: "",
                teamId = item.teamId ?: 0,
                teamName = item.teamName ?: "",
                teamTag = item.teamName ?: "",
                favorite = false
            )
            proPlayers.add(proPlayerEntity)
        }

        return proPlayers
    }

    fun mapProPlayerEntitiesToDomain(input: List<ProPlayerEntity>): List<ProPlayer> =
        input.map { item ->
            ProPlayer(
                accountId = item.accountId,
                avatar = item.avatar,
                avatarFull = item.avatarFull,
                cheese = item.cheese,
                countryCode = item.countryCode,
                fantasyRole = item.fantasyRole,
                isPro = item.isPro,
                lastLogin = item.lastLogin,
                lastMatchTime = item.lastMatchTime,
                locCountryCode = item.locCountryCode,
                name = item.name,
                personName = item.personName,
                plus = item.plus,
                profileUrl = item.profileUrl,
                steamId = item.steamId,
                teamId = item.teamId,
                teamName = item.teamName,
                teamTag = item.teamName,
                favorite = item.favorite
            )
        }

    fun mapPlayerDomainToEntity(item: ProPlayer) = ProPlayerEntity(
        accountId = item.accountId,
        avatar = item.avatar,
        avatarFull = item.avatarFull,
        avatarMedium = "",
        cheese = item.cheese,
        countryCode = item.countryCode,
        fantasyRole = item.fantasyRole,
        isPro = item.isPro,
        lastLogin = item.lastLogin,
        lastMatchTime = item.lastMatchTime,
        locCountryCode = item.locCountryCode,
        name = item.name,
        personName = item.personName,
        plus = item.plus,
        profileUrl = item.profileUrl,
        steamId = item.steamId,
        teamId = item.teamId,
        teamName = item.teamName,
        teamTag = item.teamName,
        favorite = item.favorite,
        fh_unavailable = false,
        fullHistoryTime = "",
        isLocked = false,
        lockedUntil = ""
    )
}