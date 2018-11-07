package chirikualii.com.footballapps.presentation.ui.match


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.common.*
import chirikualii.com.footballapps.presentation.base.BaseFragment
import chirikualii.com.footballapps.presentation.model.Match
import chirikualii.com.footballapps.presentation.ui.MainActivity
import chirikualii.com.footballapps.presentation.ui.adapter.PagerAdapterMatch
import chirikualii.com.footballapps.presentation.ui.match.nextmatch.NextMatchFragment
import chirikualii.com.footballapps.presentation.ui.match.prevmatch.PrevMatchFragment
import chirikualii.com.footballapps.presentation.ui.resultsearch.ResultSearchActivity
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_match.*
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject


class MatchFragment : BaseFragment(), IMatchView {
    @Inject
    lateinit var presenter: MatchPresenter

    override fun onAttach(context: Context?) {
        injectFragment(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        presenter.bind(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_match, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.toolbarLay.apply {
            this?.title = getString(R.string.match)
            this?.navigationIcon = ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow_back, null)
            this?.setNavigationOnClickListener {
                activity?.onBackPressed()

            }
        }
        viewPager.adapter = PagerAdapterMatch(
            childFragmentManager, NextMatchFragment(), PrevMatchFragment(), NEXT_MATCH,
            PREV_MATCH
        )
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {

        val searchView = SearchView((context as MainActivity).supportActionBar?.themedContext ?: context)
        menu?.findItem(R.id.search_bar).apply {
            this!!.actionView = searchView
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter.performSearch(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }

        })

        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun navigateToResultSearchActivity(match: ArrayList<Match>) {
        Intent(context, ResultSearchActivity::class.java).apply {
            this.putParcelableArrayListExtra(DATA_RESULT_SEARCH, match)
            this.putExtra(DATA_KEY_RESULT_SEARCH, MATCH)
            startActivity(this)
        }

    }

    override fun showMessage(message: String?) {
        toast(message.toString())
    }

    override fun showProgress(show: Boolean) {

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }


}




