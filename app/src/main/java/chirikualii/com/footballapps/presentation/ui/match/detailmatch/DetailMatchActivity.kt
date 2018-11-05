package chirikualii.com.footballapps.presentation.ui.match.detailmatch


import android.os.Bundle
import android.view.Menu
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.common.DATA_MATCH
import chirikualii.com.footballapps.common.MATCH
import chirikualii.com.footballapps.common.toDate
import chirikualii.com.footballapps.presentation.base.BaseActivity
import chirikualii.com.footballapps.presentation.model.Event
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_match.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class DetailMatchActivity : BaseActivity()  , IDetailMatchView {

    @Inject
    lateinit var presenter: DetailMatchPresenter
    lateinit var data: Event
    override fun onCreate(savedInstanceState: Bundle?) {
        injectActivity(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        data = intent.getParcelableExtra(DATA_MATCH)
        presenter.bind(this)
        presenter.performLoadTeamBadge(data.idTeamHome, "Home")
        presenter.performLoadTeamBadge(data.idTeamAway, "Away")
        txtDateMatch.text = data.dateMatch?.toDate()

        txtHomeTeamName?.text = data.homeTeamName
        txtScoreHomeTeam?.text = data.homeScore
        txtHomeGoalkeeper?.text = data.homeGoalkepeer
        txtHomeDefense?.text = data.homeDefender
        txtHomeMidfield?.text = data.homeMidfield
        txtHomeFoward?.text = data.homeFoward
        txtHomeGoals?.text = data.homeDetailGoals

        txtAwayTeamName?.text = data.awayTeamName
        txtScoreAwayTeam?.text = data.awayScore
        txtAwayGoalkeeper?.text = data.awayGoalkepeer
        txtAwayDefense?.text = data.awayDefender
        txtAwayMidfield?.text = data.awayMidfield
        txtAwayFoward?.text = data.awayFoward
        txtAwayGoals?.text = data.awayDetailGoals

    }

    override fun showTeamBadgeHome(teamBadge: String?) {
        Glide.with(this)
            .load(teamBadge)
            .into(imgHomeTeam)
    }

    override fun showTeamBadgeAway(teamBadge: String?) {
        Glide.with(this)
            .load(teamBadge)
            .into(imgAwayTeam)
    }

    override fun showFavorite(isFavorite: Boolean) {

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
