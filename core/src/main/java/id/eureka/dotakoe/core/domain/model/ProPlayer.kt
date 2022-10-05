package id.eureka.dotakoe.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProPlayer(
    val accountId: Int,
    val avatar: String,
    val avatarFull: String,
    val cheese: Int,
    val countryCode: String,
    val fantasyRole: Int,
    val isPro: Boolean,
    val lastLogin: String,
    val lastMatchTime: String,
    val locCountryCode: String,
    val name: String,
    val personName: String,
    val plus: Boolean,
    val profileUrl: String,
    val steamId: String,
    val teamId: Int,
    val teamName: String,
    val teamTag: String,
    val favorite: Boolean
) : Parcelable
