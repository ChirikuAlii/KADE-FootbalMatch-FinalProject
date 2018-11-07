package chirikualii.com.footballapps.presentation.ui.detailteam

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.res.ResourcesCompat
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.common.DATA_TEAM
import chirikualii.com.footballapps.common.DATA_TEAM_OVERVIEW
import chirikualii.com.footballapps.common.DATA_TEAM_PLAYERS
import chirikualii.com.footballapps.presentation.base.BaseActivity
import chirikualii.com.footballapps.presentation.model.Team
import chirikualii.com.footballapps.presentation.ui.adapter.PagerAdapterMatch
import chirikualii.com.footballapps.presentation.ui.detailteam.overviewteam.OverviewTeamFragment
import chirikualii.com.footballapps.presentation.ui.detailteam.playerteam.PlayerFragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_team.*
import org.jetbrains.anko.toast
import javax.inject.Inject


class DetailTeamActivity : BaseActivity(), IDetailTeamView {


    @Inject
    lateinit var presenter: DetailTeamPresenter
    var bundle: Bundle? = Bundle()
    var dataTeam: Team? = null
    var overviewTeamFragment = OverviewTeamFragment()
    var playerFragment = PlayerFragment()
    var menu: Menu? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        injectActivity(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)
        setSupportActionBar(toolbarLay)
        presenter.bind(this)
        dataTeam = intent.getParcelableExtra<Team>(DATA_TEAM)
        sentData(bundle)
        setupView()


    }

    private fun sentData(savedInstanceState: Bundle?) {
        savedInstanceState?.putString(DATA_TEAM_OVERVIEW, dataTeam?.overview)
        savedInstanceState?.putString(DATA_TEAM_PLAYERS, dataTeam?.idTeam)
        overviewTeamFragment.arguments = savedInstanceState
        playerFragment.arguments = savedInstanceState

    }

    private fun setupView() {
        setSupportActionBar(toolbarLay)

        toolbarLay.apply {
            navigationIcon = ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow_back, null)
            this.title = ""
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

        viewPager.adapter =
                PagerAdapterMatch(supportFragmentManager, overviewTeamFragment, playerFragment, "Overview", "Players")
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menu = menu
        presenter.performCheckInDb(dataTeam?.idTeam)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.title
        when (item?.itemId) {
            R.id.item_add_favorite -> {
                presenter.performDeleteTeam(idTeam = dataTeam?.idTeam)
            }

            R.id.item_del_favorite -> {
                presenter.performInsertTeam(team = dataTeam)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun addedToFavorite() {
        menu?.clear()
        menuInflater.inflate(R.menu.menu_del_fav, menu)
        toast("berhasil diinput")
    }

    override fun deletedFromFavorite() {
        menu?.clear()
        menuInflater.inflate(R.menu.menu_add_fav, menu)
        toast("berhasil dihapus")
    }

    override fun savedAsFavorite(isFavorite: Boolean) {
        val resMenu = if (isFavorite) R.menu.menu_del_fav else R.menu.menu_add_fav
        menuInflater.inflate(resMenu, menu)
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
