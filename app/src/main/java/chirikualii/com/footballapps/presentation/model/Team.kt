package chirikualii.com.footballapps.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by chirikualii on {DATE}
 */
@Parcelize
data class Team(
    val idTeam: String? = "",
    val teamName : String? = "",
    val badgeTeam: String? = "",
    val formedYear : String? = "",
    val stadiumName : String? = "",
    val overview : String? = ""
) : Parcelable