package chirikualii.com.footballapps.presentation.ui.resultsearch


import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.common.DATA_KEY_RESULT_SEARCH
import chirikualii.com.footballapps.common.MATCH
import chirikualii.com.footballapps.common.DATA_RESULT_SEARCH
import chirikualii.com.footballapps.common.TEAM
import chirikualii.com.footballapps.presentation.base.BaseActivity
import chirikualii.com.footballapps.presentation.model.Match
import chirikualii.com.footballapps.presentation.model.Team
import chirikualii.com.footballapps.presentation.ui.adapter.RecyclerViewMatchAdapter
import chirikualii.com.footballapps.presentation.ui.adapter.RecyclerViewTeamAdapter
import kotlinx.android.synthetic.main.activity_result_search.*


class ResultSearchActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        injectActivity(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_search)
        val key = intent?.getStringExtra(DATA_KEY_RESULT_SEARCH)
        val dataMatch = intent?.getParcelableArrayListExtra<Match>(DATA_RESULT_SEARCH)
        val dataTeams = intent?.getParcelableArrayListExtra<Team>(DATA_RESULT_SEARCH)

        when(key){

            MATCH ->{
                recyclerViewMatch.apply {
                    layoutManager = LinearLayoutManager(this@ResultSearchActivity)
                    adapter = RecyclerViewMatchAdapter(dataMatch!!.toList())
                }
            }

            TEAM ->{
                recyclerViewMatch.apply {
                    layoutManager = LinearLayoutManager(this@ResultSearchActivity)
                    adapter = RecyclerViewTeamAdapter(dataTeams!!.toList())
                }
            }

        }






    }
}
