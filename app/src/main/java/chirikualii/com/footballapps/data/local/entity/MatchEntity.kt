package chirikualii.com.footballapps.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by chirikualii on {DATE}
 */

@Entity(tableName = "match_table")
data class MatchEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    var idMatch: String? = "",
    var idTeamHome: String? = "",
    var idTeamAway: String? = "",
    var dateMatch: String? = "",
    var homeTeamName: String? = "",
    var homeScore: String? = "",
    var homeDetailGoals: String? = "",
    var homeGoalkepeer: String? = "",
    var homeDefender: String? = "",
    var homeMidfield: String? = "",
    var homeFoward: String? = "",
    var awayTeamName: String? = "",
    var awayScore: String? = "",
    var awayDetailGoals: String? = "",
    var awayGoalkepeer: String? = "",
    var awayDefender: String? = "",
    var awayMidfield: String? = "",
    var awayFoward: String? = ""
)
