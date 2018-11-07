package chirikualii.com.footballapps.presentation.ui.detailteam.overviewteam


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.common.DATA_TEAM_OVERVIEW
import kotlinx.android.synthetic.main.fragment_overview_team.*


class OverviewTeamFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_overview_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtOverviewTeam.text = this.arguments?.getString(DATA_TEAM_OVERVIEW)
    }


}
