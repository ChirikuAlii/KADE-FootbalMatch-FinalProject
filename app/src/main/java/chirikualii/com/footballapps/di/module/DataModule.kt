package chirikualii.com.footballapps.di.module

import android.content.Context
import androidx.room.Room
import chirikualii.com.footballapps.data.local.dao.FootballAppsDb
import chirikualii.com.footballapps.data.local.dao.MatchDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by chirikualii on {DATE}
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideRoomDb( context: Context): FootballAppsDb =
            Room.databaseBuilder(context,FootballAppsDb::class.java,"football.db")
                .allowMainThreadQueries()
                .build()
    @Provides
    @Singleton
    fun provideMatchDao(db: FootballAppsDb) : MatchDao = db.matchDao()
}