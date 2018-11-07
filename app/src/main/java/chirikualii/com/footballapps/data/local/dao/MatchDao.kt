package chirikualii.com.footballapps.data.local.dao

import androidx.room.*
import chirikualii.com.footballapps.data.local.entity.MatchEntity
import chirikualii.com.footballapps.presentation.model.Event
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable

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


}