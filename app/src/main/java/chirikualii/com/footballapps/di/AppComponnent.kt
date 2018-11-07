package chirikualii.com.footballapps.di

import android.app.Application
import chirikualii.com.footballapps.BaseApp
import chirikualii.com.footballapps.di.builder.ActivityBuilderModule
import chirikualii.com.footballapps.di.module.AppModule
import chirikualii.com.footballapps.di.module.DataModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by chirikualii on {DATE}
 */

@Singleton
@Component(
    modules = [
        (ActivityBuilderModule::class),
        (AppModule::class),
        (AndroidSupportInjectionModule::class),
        (DataModule::class)
    ]
)
interface AppComponnent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponnent
    }

    fun inject(app: BaseApp)
}