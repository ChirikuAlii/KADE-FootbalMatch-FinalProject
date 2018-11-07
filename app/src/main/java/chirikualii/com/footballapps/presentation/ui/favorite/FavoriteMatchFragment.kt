package chirikualii.com.footballapps.presentation.ui.favorite


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.presentation.base.BaseFragment
import chirikualii.com.footballapps.presentation.model.Event
import chirikualii.com.footballapps.presentation.ui.adapter.RecyclerViewMatchAdapter
import kotlinx.android.synthetic.main.fragment_favorite_list.*
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject


class FavoriteMatchFragment : BaseFragment() , IFavoriteView {

    @Inject
    lateinit var presenter: FavoritePresenter

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

    }

    override fun showFavorite(event: List<Event>) {
        recyclerViewMatch.adapter = RecyclerViewMatchAdapter(event)
    }

    override fun showMessage(message: String?) {
        toast(message.toString())
    }

    override fun showProgress(show: Boolean) {
        progressCircular.visibility = if (show) View.VISIBLE else View.GONE
        recyclerViewMatch.visibility =if (show) View.GONE else View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        presenter.performLoadData()
    }



}
