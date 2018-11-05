package chirikualii.com.footballapps.presentation.ui.teams


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_teams.*
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.common.*
import chirikualii.com.footballapps.presentation.base.BaseFragment
import chirikualii.com.footballapps.presentation.model.Team
import chirikualii.com.footballapps.presentation.ui.MainActivity
import chirikualii.com.footballapps.presentation.ui.adapter.RecyclerViewTeamAdapter
import chirikualii.com.footballapps.presentation.ui.resultsearch.ResultSearchActivity
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

class TeamsFragment : BaseFragment() , ITeamsView , AdapterView.OnItemSelectedListener {

    @Inject
    lateinit var presenter: TeamsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onAttach(context: Context?) {
        injectFragment(this)
        super.onAttach(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =inflater.inflate(R.layout.fragment_teams, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.bind(this)
        //setup toolbar
        this.setupToolbar()
        this.setupSpinner()
        recyclerViewMatch.layoutManager = LinearLayoutManager(context)

    }

    private fun setupToolbar() {
        activity?.toolbarLay?.title = "Teams"
        activity?.toolbarLay?.navigationIcon = ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow_back, null)
        activity?.toolbarLay?.setNavigationOnClickListener {
            activity?.onBackPressed()

        }
    }

    private fun setupSpinner() {
        val leagues = resources.getStringArray(R.array.spinner_league)
        val adapterSpinner = ArrayAdapter(context, android.R.layout.simple_spinner_item, leagues)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerLeague.adapter = adapterSpinner
        spinnerLeague.onItemSelectedListener = this
    }


    override fun showLoadData(teams: List<Team>) {
        recyclerViewMatch.adapter = RecyclerViewTeamAdapter(teams)
    }

    override fun showMessage(message: String?) {
        toast(message.toString())
    }

    override fun showProgress(show: Boolean) {
       progressCircular.visibility = if (show) View.VISIBLE else View.GONE
       recyclerViewMatch.visibility = if (show) View.GONE else View.VISIBLE
    }

    override fun navigateToResultSearcActivity(teams: ArrayList<Team>) {
        Intent(context,ResultSearchActivity::class.java).apply {
            putExtra(DATA_KEY_RESULT_SEARCH, TEAM)
            putParcelableArrayListExtra(DATA_RESULT_SEARCH,teams)
            startActivity(this)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (position) {
            0 -> {
                presenter.performLoadData(ID_PREMIER_LEAGUE)

            }
            1 -> {
                presenter.performLoadData(ID_LA_LIGA)
            }
            2 -> {
                presenter.performLoadData(ID_SERIA_A)
            }
            3 -> {
                presenter.performLoadData(ID_BUNDESLIGA)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {

        val searchView = SearchView((context as MainActivity).supportActionBar?.themedContext ?: context)
        menu?.findItem(R.id.search_bar).apply {

            this!!.actionView = searchView

        }


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
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
    override fun onResume() {
        super.onResume()
        presenter.performLoadData(ID_PREMIER_LEAGUE)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }


}




