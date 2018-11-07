package chirikualii.com.footballapps.presentation.ui.favorite


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.common.logD
import chirikualii.com.footballapps.data.local.dao.MatchDao
import chirikualii.com.footballapps.data.repo.EventsRepo
import chirikualii.com.footballapps.presentation.base.BaseFragment
import chirikualii.com.footballapps.presentation.model.Event
import chirikualii.com.footballapps.presentation.ui.adapter.RecyclerViewMatchAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_favorite_list.*
import javax.inject.Inject


class FavoriteMatchFragment : BaseFragment() , IFavoriteView {

    @Inject
    lateinit var presenter: FavoritePresenter
    @Inject
    lateinit var eventsRepo: EventsRepo
    @Inject
    lateinit var dao: MatchDao
    override fun onAttach(context: Context?) {
        injectFragment(this)
        super.onAttach(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.bind(this)
        recyclerViewMatch.layoutManager = LinearLayoutManager(context)
        presenter.performLoadData()

       //presenter.performLoadData()



    }

    override fun showFavorite(event: List<Event>) {
        recyclerViewMatch.adapter = RecyclerViewMatchAdapter(event)
    }

    override fun showMessage(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress(show: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResume() {
        super.onResume()
        presenter.performLoadData()
    }



}
