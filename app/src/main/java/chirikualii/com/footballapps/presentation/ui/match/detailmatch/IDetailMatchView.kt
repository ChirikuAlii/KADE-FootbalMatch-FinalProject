package chirikualii.com.footballapps.presentation.ui.match.detailmatch

import chirikualii.com.footballapps.presentation.base.BaseView

/**
 * Created by chirikualii on {DATE}
 */
interface IDetailMatchView : BaseView {
    fun showTeamBadgeHome(teamBadge: String?)
    fun showTeamBadgeAway(teamBadge: String?)
    fun showFavorite(isFavorite: Boolean)
}