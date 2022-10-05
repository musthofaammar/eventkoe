package id.eureka.dotakoe.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ProPlayerResponse(

	@field:SerializedName("profileurl")
	val profileurl: String? = null,

	@field:SerializedName("is_locked")
	val isLocked: Boolean? = null,

	@field:SerializedName("last_login")
	val lastLogin: String? = null,

	@field:SerializedName("fantasy_role")
	val fantasyRole: Int? = null,

	@field:SerializedName("avatarfull")
	val avatarfull: String? = null,

	@field:SerializedName("fh_unavailable")
	val fhUnavailable: Boolean? = null,

	@field:SerializedName("team_tag")
	val teamTag: String? = null,

	@field:SerializedName("avatarmedium")
	val avatarmedium: String? = null,

	@field:SerializedName("locked_until")
	val lockedUntil: String? = null,

	@field:SerializedName("avatar")
	val avatar: String? = null,

	@field:SerializedName("team_id")
	val teamId: Int? = null,

	@field:SerializedName("personaname")
	val personaname: String? = null,

	@field:SerializedName("plus")
	val plus: Boolean? = null,

	@field:SerializedName("team_name")
	val teamName: String? = null,

	@field:SerializedName("full_history_time")
	val fullHistoryTime: String? = null,

	@field:SerializedName("cheese")
	val cheese: Int? = null,

	@field:SerializedName("steamid")
	val steamid: String? = null,

	@field:SerializedName("last_match_time")
	val lastMatchTime: String? = null,

	@field:SerializedName("country_code")
	val countryCode: String? = null,

	@field:SerializedName("account_id")
	val accountId: Int? = null,

	@field:SerializedName("is_pro")
	val isPro: Boolean? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("loccountrycode")
	val loccountrycode: String? = null
)
