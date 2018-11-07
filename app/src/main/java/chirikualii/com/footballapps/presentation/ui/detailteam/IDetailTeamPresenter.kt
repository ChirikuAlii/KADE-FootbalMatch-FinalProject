package chirikualii.com.footballapps.presentation.ui.detailteam

import chirikualii.com.footballapps.presentation.model.Team

/**
 * Created by chirikualii on 11/7/18
 * github.com/chirikualii
 */
interface IDetailTeamPresenter {
    fun performInsertTeam(team: Team?)
    fun performDeleteTeam(idTeam: String?)
    fun performCheckInDb(idTeam: String?)

}