package chirikualii.com.footballapps.di

import chirikualii.com.footballapps.presentation.ui.MainActivity
import chirikualii.com.footballapps.presentation.ui.match.detailmatch.DetailMatchActivity
import chirikualii.com.footballapps.presentation.ui.resultsearch.ResultSearchActivity
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
}