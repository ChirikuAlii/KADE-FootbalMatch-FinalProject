package chirikualii.com.footballapps.presentation.ui.teams.detailteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.presentation.ui.adapter.PagerAdapterMatch
import chirikualii.com.footballapps.presentation.ui.teams.detailteam.overviewteam.OverviewTeamFragment
import chirikualii.com.footballapps.presentation.ui.teams.detailteam.playerteam.PlayerFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_detail_team.*


class DetailTeamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)

        toolbarLay.apply {
            navigationIcon = ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow_back, null)
            setNavigationOnClickListener {
                onBackPressed()

            }
        }

        viewPager.adapter = PagerAdapterMatch(supportFragmentManager,OverviewTeamFragment(),PlayerFragment(),"Overview","Players")
        tabLayout.setupWithViewPager(viewPager)



    }
}
