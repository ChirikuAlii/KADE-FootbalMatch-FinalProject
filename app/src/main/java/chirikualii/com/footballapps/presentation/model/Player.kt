package chirikualii.com.footballapps.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by chirikualii on {DATE}
 */
@Parcelize
data class Player(
    val idPlayer: String? = "",
    val namePlayer: String? = "",
    val imgPlayer: String? = "",
    val weightPlayer: String? = "",
    val heightPlayer: String? = "",
    val overviewPlayer: String? = "",
    val positionPlayer: String? = "",
    val imgPosterPlayer: String? = ""
) : Parcelable