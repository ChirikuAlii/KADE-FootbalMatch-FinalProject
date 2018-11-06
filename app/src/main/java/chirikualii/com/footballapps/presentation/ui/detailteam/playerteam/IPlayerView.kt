package chirikualii.com.footballapps.presentation.ui.detailteam.playerteam

import chirikualii.com.footballapps.presentation.base.BaseView
import chirikualii.com.footballapps.presentation.model.Player

/**
 * Created by chirikualii on {DATE}
 */
interface IPlayerView : BaseView {
    fun showPlayersList(players : List<Player>)
}