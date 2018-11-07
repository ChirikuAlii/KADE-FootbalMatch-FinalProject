package chirikualii.com.footballapps.data.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import chirikualii.com.footballapps.data.local.entity.MatchEntity

/**
 * Created by chirikualii on {DATE}
 */
@Database(
    entities = [MatchEntity::class],version = 1
)
abstract class FootballAppsDb : RoomDatabase() {
    abstract fun matchDao() :MatchDao
}