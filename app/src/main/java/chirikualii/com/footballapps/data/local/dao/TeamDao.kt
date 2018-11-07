package chirikualii.com.footballapps.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import chirikualii.com.footballapps.data.local.entity.TeamEntity

/**
 * Created by chirikualii on 11/7/18
 * github.com/chirikualii
 */
@Dao
interface TeamDao {

    @Insert
    fun insertTeam(team: TeamEntity)

    @Query ("SELECT * FROM team_table")
    fun getAllTeam() : List<TeamEntity>

    @Query("DELETE FROM team_table WHERE idTeam = :idTeam")
    fun deleteTeam(idTeam : String?)

    @Query("SELECT id , idTeam FROM team_table WHERE idTeam = :idTeam")
    fun checkTeamInDb(idTeam: String?): List<TeamEntity>
}