package chirikualii.com.footballapps.presentation.ui.favorite


import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.common.FAVORITE
import chirikualii.com.footballapps.common.MATCH
import chirikualii.com.footballapps.common.NEXT_MATCH
import chirikualii.com.footballapps.common.TEAM
import chirikualii.com.footballapps.data.repo.EventsRepo
import chirikualii.com.footballapps.presentation.base.BaseFragment
import chirikualii.com.footballapps.presentation.model.Event
import chirikualii.com.footballapps.presentation.ui.adapter.PagerAdapterMatch
import kotlinx.android.synthetic.main.fragment_favorite.*
import javax.inject.Inject
import kotlinx.android.synthetic.main.app_bar_main.*


class FavoriteFragment : BaseFragment() {


    override fun onAttach(context: Context?) {
        injectFragment(this)
        super.onAttach(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        setupView()

    }

    private fun setupView() {
        activity?.toolbarLay.apply {
            this?.title = FAVORITE
            this?.menu?.clear()
            this?.setNavigationOnClickListener {
                activity?.onBackPressed()
            }
        }
        viewPager.adapter = PagerAdapterMatch(childFragmentManager,FavoriteMatchFragment(),FavoriteTeamFragment(),
            MATCH, TEAM)
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        menu?.clear()
    }


}
