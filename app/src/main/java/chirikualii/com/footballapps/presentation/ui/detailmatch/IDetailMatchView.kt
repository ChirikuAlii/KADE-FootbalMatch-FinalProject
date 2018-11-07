package chirikualii.com.footballapps.presentation.ui.detailmatch

import chirikualii.com.footballapps.presentation.base.BaseView
import chirikualii.com.footballapps.presentation.model.Event

/**
 * Created by chirikualii on {DATE}
 */
interface IDetailMatchView : BaseView {
    fun showTeamBadgeHome(teamBadge: String?)
    fun showTeamBadgeAway(teamBadge: String?)

    fun addedToFavorite()
    fun deletedFromFavorite()
}