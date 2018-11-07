package chirikualii.com.footballapps.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by chirikualii on {DATE}
 */


@Parcelize
data class Match(
    val idLong: Long? = null,
    val idTeamHome: String? = "",
    val idTeamAway: String? = "",
    val idMatch: String? = "",
    val dateMatch: String? = "",
    val homeTeamName: String? = "",
    val homeScore: String? = "",
    val homeDetailGoals: String? = "",
    val homeGoalkepeer: String? = "",
    val homeDefender: String? = "",
    val homeMidfield: String? = "",
    val homeFoward: String? = "",
    val awayTeamName: String? = "",
    val awayScore: String? = "",
    val awayDetailGoals: String? = "",
    val awayGoalkepeer: String? = "",
    val awayDefender: String? = "",
    val awayMidfield: String? = "",
    val awayFoward: String? = "",
    var isFavorite: Int? = 0
) : Parcelable