package chirikualii.com.footballapps.presentation.ui.teams.detailteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.common.DATA_TEAM
import chirikualii.com.footballapps.common.DATA_TEAM_OVERVIEW
import chirikualii.com.footballapps.presentation.model.Team
import chirikualii.com.footballapps.presentation.ui.adapter.PagerAdapterMatch
import chirikualii.com.footballapps.presentation.ui.teams.detailteam.overviewteam.OverviewTeamFragment
import chirikualii.com.footballapps.presentation.ui.teams.detailteam.playerteam.PlayerFragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_team.*


class DetailTeamActivity : AppCompatActivity() {
    var bundle : Bundle? =Bundle()
    var dataTeam : Team? = null
    var overviewTeamFragment =OverviewTeamFragment()
    var playerFragment = PlayerFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)
        dataTeam = intent.getParcelableExtra<Team>(DATA_TEAM)
        sentData(bundle)
        setupView()



    }

    private fun sentData(savedInstanceState: Bundle?) {
        savedInstanceState?.putString(DATA_TEAM_OVERVIEW, dataTeam?.overview)
        overviewTeamFragment.arguments = savedInstanceState
    }

    private fun setupView() {
        toolbarLay.apply {
            navigationIcon = ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow_back, null)
            setNavigationOnClickListener {
                onBackPressed()

            }
        }
        Glide
            .with(this)
            .load(dataTeam?.badgeTeam)
            .into(imgTeam)

        txtTeamName.text = dataTeam?.teamName
        txtFormed.text = dataTeam?.formedYear
        txtStadiumName.text = dataTeam?.stadiumName

        viewPager.adapter = PagerAdapterMatch(supportFragmentManager, overviewTeamFragment,playerFragment, "Overview", "Players")
        tabLayout.setupWithViewPager(viewPager)
    }
}
