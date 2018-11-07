package chirikualii.com.footballapps.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by chirikualii on 11/7/18
 * github.com/chirikualii
 */

@Entity(tableName = "team_table")
data class TeamEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var idTeam: String? = "",
    var teamName: String? = "",
    var badgeTeam: String? = "",
    var formedYear: String? = "",
    var stadiumName: String? = "",
    var overview: String? = ""
)
