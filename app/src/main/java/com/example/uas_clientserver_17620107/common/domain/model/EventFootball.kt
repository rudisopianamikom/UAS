package com.example.uas_clientserver_17620107.common.domain.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


data class EventFootball (
        @Json(name = "events") val events: List<Events>
)
@Parcelize
data class Events (
        val id : Long?,
        @Json(name = "idEvent") val idEvent : String?,

        @Json(name = "strHomeTeam") val strHomeTeam : String?,
        @Json(name = "strAwayTeam") val strAwayTeam : String?,

        @Json(name = "intHomeScore") val intHomeScore : String?,
        @Json(name = "intAwayScore")val intAwayScore : String?,

        @Json(name = "intHomeShots") val intHomeShots : String?,
        @Json(name = "intAwayShots") val intAwayShots : String?,

        @Json(name = "dateEvent") val dateEvent : String?,

        @Json(name = "strHomeGoalDetails") val strHomeGoalDetails : String?,
        @Json(name = "strHomeLineupGoalkeeper") val strHomeLineupGoalkeeper : String?,
        @Json(name = "strHomeLineupDefense") val strHomeLineupDefense : String?,
        @Json(name = "strHomeLineupMidfield") val strHomeLineupMidfield : String?,
        @Json(name = "strHomeLineupForward") val strHomeLineupForward : String?,
        @Json(name = "strHomeLineupSubstitutes") val strHomeLineupSubstitutes : String?,

        @Json(name = "strAwayGoalDetails") val strAwayGoalDetails : String?,
        @Json(name = "strAwayLineupGoalkeeper") val strAwayLineupGoalkeeper : String?,
        @Json(name = "strAwayLineupDefense") val strAwayLineupDefense : String?,
        @Json(name = "strAwayLineupMidfield") val strAwayLineupMidfield : String?,
        @Json(name = "strAwayLineupForward") val strAwayLineupForward : String?,
        @Json(name = "strAwayLineupSubstitutes") val strAwayLineupSubstitutes : String?,

        var strTeamHomeBadge : String?,
        var strTeamAwayBadge : String?

) : Parcelable {
    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE"

        const val ID: String = "ID_"
        const val ID_EVENT : String = "ID_EVENT"

        const val HOME_TEAM : String = "HOME_TEAM"
        const val AWAY_TEAM : String = "AWAY_TEAM"

        const val HOME_SCORE : String = "HOME_SCORE"
        const val AWAY_SCORE : String = "AWAY_SCORE"

        const val HOME_SHOT : String = "HOME_SHOT"
        const val AWAY_SHOT : String = "AWAY_SHOT"

        const val DATE_EVENT : String = "DATE_EVENT"

        const val HOME_GOAL_DETAIL : String = "HOME_GOAL_DETAIL"
        const val HOME_LINEUP_GOALKEEPER : String  = "HOME_LINEUP_GOALKEEPER"
        const val HOME_LINEUP_DEFENCE : String = "HOME_LINEUP_DEFENCE"
        const val HOME_LINEUP_MIDFIELD : String = "HOME_LINEUP_MIDFIELD"
        const val HOME_LINEUP_FORWARD : String = "HOME_LINEUP_FORWARD"
        const val HOME_LINEUP_SUBTITUTIES : String = "HOME_LINEUP_SUBTITUTIES"

        const val AWAY_GOAL_DETAIL : String = "AWAY_GOAL_DETAIL"
        const val AWAY_LINEUP_GOALKEEPER : String = "AWAY_LINEUP_GOALKEEPER"
        const val AWAY_LINEUP_DEFENCE : String = "AWAY_LINEUP_DEFENCE"
        const val AWAY_LINEUP_MIDFIELD : String = "AWAY_LINEUP_MIDFIELD"
        const val AWAY_LINEUP_FORWARD : String= "AWAY_LINEUP_FORWARD"
        const val AWAY_LINEUP_SUBTITUTIES : String= "AWAY_LINEUP_SUBTITUTIES"

        const val HOME_BADGE : String = "HOME_BADGE"
        const val AWAY_BADGE : String = "AWAY_BADGE"
    }
}