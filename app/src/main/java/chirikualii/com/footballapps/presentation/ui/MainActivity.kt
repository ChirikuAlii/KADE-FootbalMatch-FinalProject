package chirikualii.com.footballapps.presentation.ui


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.presentation.base.BaseActivity
import chirikualii.com.footballapps.presentation.ui.favorite.FavoriteFragment
import chirikualii.com.footballapps.presentation.ui.match.MatchFragment
import chirikualii.com.footballapps.presentation.ui.teams.TeamsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        injectActivity(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbarLay)
        bottom_navbar.setOnNavigationItemSelectedListener(this)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.lay_container, MatchFragment(), "MatchFragment")
            .commit()


    }

    override fun onNavigationItemSelected(menu: MenuItem): Boolean {
        when (menu.itemId) {
            R.id.item_match -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.lay_container, MatchFragment(), "MatchFragment")
                    .commit()
                return true
            }
            R.id.item_team -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.lay_container, TeamsFragment(), "TeamFragment")
                    .commit()

                return true
            }
            R.id.item_favorite -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.lay_container, FavoriteFragment(), "FavoriteFragment")
                    .commit()
                return true
            }

        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        // searchView = SearchView((this).supportActionBar?.themedContext ?: this)


        return super.onCreateOptionsMenu(menu)

    }
}
