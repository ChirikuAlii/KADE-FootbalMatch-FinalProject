package chirikualii.com.footballapps.di.builder

import chirikualii.com.footballapps.presentation.ui.detailteam.playerteam.PlayerFragment
import chirikualii.com.footballapps.presentation.ui.favorite.FavoriteFragment
import chirikualii.com.footballapps.presentation.ui.favorite.FavoriteMatchFragment
import chirikualii.com.footballapps.presentation.ui.favorite.FavoriteTeamFragment
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
    abstract fun bindMatchFragment(): MatchFragment

    @ContributesAndroidInjector
    abstract fun bindNextMatchFragment(): NextMatchFragment

    @ContributesAndroidInjector
    abstract fun bindPrevMatchFragmnet(): PrevMatchFragment

    @ContributesAndroidInjector
    abstract fun bindFavoriteFragment(): FavoriteFragment

    @ContributesAndroidInjector
    abstract fun bindTeamFragment(): TeamsFragment

    @ContributesAndroidInjector
    abstract fun bindPlayerFragment(): PlayerFragment

    @ContributesAndroidInjector
    abstract fun bindFavoriteTeamFragment(): FavoriteTeamFragment

    @ContributesAndroidInjector
    abstract fun bindFavoriteMatchFragment(): FavoriteMatchFragment
}