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

    @Query("DELETE FROM match_table WHERE idEvent = :idEvent ")
    fun deleteMatch (idEvent: String?)

    @Query("SELECT id,idEvent FROM match_table WHERE idEvent = :idEvent")
    fun checkDataMatch(idEvent :String?) : List<MatchEntity>


}