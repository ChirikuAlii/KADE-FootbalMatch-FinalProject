package chirikualii.com.footballapps.presentation.ui.match.nextmatch


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.common.ID_BUNDESLIGA
import chirikualii.com.footballapps.common.ID_LA_LIGA
import chirikualii.com.footballapps.common.ID_PREMIER_LEAGUE
import chirikualii.com.footballapps.common.ID_SERIA_A
import chirikualii.com.footballapps.common.scheduler.AppSchedulerProvider
import chirikualii.com.footballapps.presentation.base.BaseFragment
import chirikualii.com.footballapps.presentation.model.Match
import chirikualii.com.footballapps.presentation.ui.adapter.RecyclerViewMatchAdapter
import kotlinx.android.synthetic.main.fragment_list_match.*
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject


class NextMatchFragment : BaseFragment(), INextMatchView, AdapterView.OnItemSelectedListener {


    @Inject
    lateinit var presenter: NextMatchPresenter


    override fun onAttach(context: Context?) {
        injectFragment(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_list_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.bind(this)
        presenter.bindTest(AppSchedulerProvider())
        recyclerViewMatch.layoutManager = LinearLayoutManager(context)
        this.setupSpinner()

    }


    private fun setupSpinner() {
        val leagues = resources.getStringArray(R.array.spinner_league)
        val adapterSpinner = ArrayAdapter(context, android.R.layout.simple_spinner_item, leagues)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerLeague.adapter = adapterSpinner
        spinnerLeague.onItemSelectedListener = this
    }

    override fun showMessage(message: String?) {
        toast(message.toString())
    }

    override fun showProgress(show: Boolean) {
        progressCircular.visibility = if (show) View.VISIBLE else View.GONE
        recyclerViewMatch.visibility = if (show) View.GONE else View.VISIBLE
    }

    override fun setOnSuccessLoad(match: List<Match>) {
        recyclerViewMatch.adapter = RecyclerViewMatchAdapter(match)
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

    override fun onResume() {
        super.onResume()
        presenter.performLoadData(ID_PREMIER_LEAGUE)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }


}
