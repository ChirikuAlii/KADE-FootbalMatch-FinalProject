package chirikualii.com.footballapps.data.local.dao

import androidx.room.*
import chirikualii.com.footballapps.data.local.entity.MatchEntity


/**
 * Created by chirikualii on {DATE}
 */
@Dao
interface MatchDao {

    @Insert
    fun insertMatch(match : MatchEntity)

    @Query("SELECT * FROM match_table")
    fun getAllMatch() : List<MatchEntity>

    @Query("DELETE FROM match_table WHERE idMatch = :idMatch ")
    fun deleteMatch (idMatch: String?)

    @Query("SELECT id,idMatch FROM match_table WHERE idMatch = :idMatch")
    fun checkDataMatch(idMatch :String?) : List<MatchEntity>


}