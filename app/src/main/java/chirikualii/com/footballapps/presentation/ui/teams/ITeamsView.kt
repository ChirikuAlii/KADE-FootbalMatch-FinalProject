package chirikualii.com.footballapps.presentation.ui.teams

import chirikualii.com.footballapps.presentation.base.BaseView
import chirikualii.com.footballapps.presentation.model.Team

/**
 * Created by chirikualii on {DATE}
 */
interface ITeamsView : BaseView {
    fun showLoadData(teams: List<Team>)
    fun navigateToResultSearcActivity(teams: ArrayList<Team>)
}