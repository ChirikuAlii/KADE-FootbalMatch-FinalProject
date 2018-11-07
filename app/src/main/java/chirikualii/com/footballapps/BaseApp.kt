package chirikualii.com.footballapps

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import chirikualii.com.footballapps.di.DaggerAppComponnent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class BaseApp : Application(), HasActivityInjector, HasSupportFragmentInjector {


    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var supportFragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponnent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }


    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return supportFragmentDispatchingAndroidInjector
    }

}