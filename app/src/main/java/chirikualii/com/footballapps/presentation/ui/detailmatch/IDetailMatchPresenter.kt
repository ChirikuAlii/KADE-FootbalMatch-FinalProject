package chirikualii.com.footballapps.presentation.ui.detailmatch

import chirikualii.com.footballapps.presentation.model.Match

/**
 * Created by chirikualii on {DATE}
 */
interface IDetailMatchPresenter {
    fun performInsertMatch(match : Match?)
    fun performDeleteMatch(idMatch: String?)
    fun performLoadTeamBadge(idTeam: String?, key: String)
    fun performCheckDataInDb(idMatch: String?)
}