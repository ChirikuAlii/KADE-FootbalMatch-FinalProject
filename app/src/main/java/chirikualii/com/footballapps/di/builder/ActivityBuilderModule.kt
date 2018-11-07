package chirikualii.com.footballapps.di.builder

import chirikualii.com.footballapps.presentation.ui.MainActivity
import chirikualii.com.footballapps.presentation.ui.detailmatch.DetailMatchActivity
import chirikualii.com.footballapps.presentation.ui.resultsearch.ResultSearchActivity
import chirikualii.com.footballapps.presentation.ui.detailteam.DetailTeamActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by chirikualii on {DATE}
 */
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindDetailMatchActivity() : DetailMatchActivity

    @ContributesAndroidInjector
    abstract fun bindResultSearchActivity() : ResultSearchActivity

    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun bindDetailTeamActivity() : DetailTeamActivity
}