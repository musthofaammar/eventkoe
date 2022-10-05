package id.eureka.dotakoe.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "proPlayer")
data class ProPlayerEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "accountId")
    val accountId: Int,

    @ColumnInfo(name = "avatar")
    val avatar: String,

    @ColumnInfo(name = "avatarFull")
    val avatarFull: String,

    @ColumnInfo(name = "avatarMedium")
    val avatarMedium: String,

    @ColumnInfo(name = "cheese")
    val cheese: Int,

    @ColumnInfo(name = "countryCode")
    val countryCode: String,

    @ColumnInfo(name = "fantasyRole")
    val fantasyRole: Int,

    @ColumnInfo(name = "fhUnavailable")
    val fh_unavailable: Boolean,

    @ColumnInfo(name = "fullHistoryTime")
    val fullHistoryTime: String,

    @ColumnInfo(name = "isLocked")
    val isLocked: Boolean,

    @ColumnInfo(name = "isPro")
    val isPro: Boolean,

    @ColumnInfo(name = "lastLogin")
    val lastLogin: String,

    @ColumnInfo(name = "lastMatchTime")
    val lastMatchTime: String,

    @ColumnInfo(name = "locCountryCode")
    val locCountryCode: String,

    @ColumnInfo(name = "lockedUntil")
    val lockedUntil: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "personName")
    val personName: String,

    @ColumnInfo(name = "plus")
    val plus: Boolean,

    @ColumnInfo(name = "profileUrl")
    val profileUrl: String,

    @ColumnInfo(name = "steamId")
    val steamId: String,

    @ColumnInfo(name = "teamId")
    val teamId: Int,

    @ColumnInfo(name = "teamName")
    val teamName: String,

    @ColumnInfo(name = "teamTag")
    val teamTag: String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean
)