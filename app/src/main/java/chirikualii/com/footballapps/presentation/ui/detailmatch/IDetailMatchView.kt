package chirikualii.com.footballapps.presentation.ui.detailmatch

import chirikualii.com.footballapps.presentation.base.BaseView

/**
 * Created by chirikualii on {DATE}
 */
interface IDetailMatchView : BaseView {
    fun showTeamBadgeHome(teamBadge: String?)
    fun showTeamBadgeAway(teamBadge: String?)

    fun addedToFavorite()
    fun deletedFromFavorite()
    fun savedAsFavorite(isFavorite : Boolean)
}