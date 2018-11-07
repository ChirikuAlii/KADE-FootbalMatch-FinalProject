package chirikualii.com.footballapps.presentation.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created by chirikualii on {DATE}
 */
class PagerAdapterMatch(
    fm: FragmentManager,
    val fragment1: Fragment,
    val fragment2: Fragment,
    val title1: String,
    val title2: String
) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                return fragment1
            }
            1 -> {
                return fragment2
            }

        }
        return null
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return title1
            }

            1 -> {
                return title2
            }
        }
        return super.getPageTitle(position)
    }

}