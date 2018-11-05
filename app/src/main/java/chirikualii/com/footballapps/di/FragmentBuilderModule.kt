package chirikualii.com.footballapps.di

import chirikualii.com.footballapps.presentation.ui.favorite.FavoriteFragment
import chirikualii.com.footballapps.presentation.ui.match.MatchFragment
import chirikualii.com.footballapps.presentation.ui.match.nextmatch.NextMatchFragment
import chirikualii.com.footballapps.presentation.ui.match.prevmatch.PrevMatchFragment
import chirikualii.com.footballapps.presentation.ui.teams.TeamsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by chirikualii on {DATE}
 */
@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector()
    abstract fun bindMatchFragment() : MatchFragment

    @ContributesAndroidInjector
    abstract fun bindNextMatchFragment() : NextMatchFragment

    @ContributesAndroidInjector
    abstract fun bindPrevMatchFragmnet() : PrevMatchFragment

    @ContributesAndroidInjector
    abstract fun bindFavoriteFragment() : FavoriteFragment

    @ContributesAndroidInjector
    abstract fun bindTeamFragment(): TeamsFragment
}