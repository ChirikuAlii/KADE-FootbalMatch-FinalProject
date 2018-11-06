package chirikualii.com.footballapps.presentation.ui.detailteam.playerteam


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.common.DATA_TEAM_PLAYERS
import chirikualii.com.footballapps.presentation.base.BaseFragment
import chirikualii.com.footballapps.presentation.model.Player
import chirikualii.com.footballapps.presentation.ui.adapter.RecyclerViewPlayerAdapter
import kotlinx.android.synthetic.main.fragment_player.*
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

class PlayerFragment : BaseFragment() , IPlayerView {

    @Inject
    lateinit var presenter: PlayerPresenter
    override fun onAttach(context: Context?) {
        injectFragment(this)

        super.onAttach(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.bind(this)
        val data =arguments?.getString(DATA_TEAM_PLAYERS)
        toast(data.toString())
        recyclerViewPlayer.layoutManager = LinearLayoutManager(context)
        presenter.perfromLoadData(data)



    }

    override fun showPlayersList(players: List<Player>) {
        recyclerViewPlayer.adapter = RecyclerViewPlayerAdapter(players)
    }

    override fun showMessage(message: String?) {
        toast(message.toString())
    }

    override fun showProgress(show: Boolean) {
        progressCircular.visibility = if (show) View.VISIBLE else View.GONE
        recyclerViewPlayer.visibility = if (show) View.GONE else View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun onResume() {
        super.onResume()

    }
}
