package chirikualii.com.footballapps.presentation.ui.detailmatch


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.common.DATA_MATCH
import chirikualii.com.footballapps.common.toDate
import chirikualii.com.footballapps.presentation.base.BaseActivity
import chirikualii.com.footballapps.presentation.model.Event
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.activity_detail_match.*
import kotlinx.android.synthetic.main.app_bar_main.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class DetailMatchActivity : BaseActivity()  , IDetailMatchView {

    @Inject
    lateinit var presenter: DetailMatchPresenter
    lateinit var data: Event
    var menu : Menu? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        injectActivity(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        setSupportActionBar(toolbarLay)
        data = intent.getParcelableExtra(DATA_MATCH)
        presenter.bind(this)
        presenter.performLoadTeamBadge(data.idTeamHome, "Home")
        presenter.performLoadTeamBadge(data.idTeamAway, "Away")


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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

    override fun showMessage(message: String?) {
       toast(message.toString())

    }

    override fun showProgress(show: Boolean) {

    }

    override fun addedToFavorite() {
        menu?.clear()
        menuInflater.inflate(R.menu.menu_del_fav,menu)
        toast("added to favorite")

    }

    override fun deletedFromFavorite() {
        menu?.clear()
        menuInflater.inflate(R.menu.menu_add_fav,menu)
        toast("deleted from favorite")

    }

    override fun savedAsFavorite(isFavorite: Boolean) {
       val resMenu = if (isFavorite) R.menu.menu_del_fav else R.menu.menu_add_fav
        menuInflater.inflate(resMenu,menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menu=menu
        presenter.performCheckDataInDb(data.idEvent ?: "")
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            R.id.item_add_favorite-> {
                presenter.performDeleteEvent(idEvent = data.idEvent)
            }

            R.id.item_del_favorite -> {
                presenter.performInsertEvent(event = data)
            }


        }

        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}
