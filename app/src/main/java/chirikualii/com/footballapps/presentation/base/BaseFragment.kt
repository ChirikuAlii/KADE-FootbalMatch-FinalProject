package chirikualii.com.footballapps.presentation.base

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
abstract class BaseFragment : Fragment() , HasSupportFragmentInjector {

    @Inject
    lateinit var childFragment: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return childFragment
    }

    override fun onAttach(context: Context?) {
        injectFragment(this)
        super.onAttach(context)
    }

    fun injectFragment(fragment: Fragment){
        AndroidSupportInjection.inject(fragment)
    }
}