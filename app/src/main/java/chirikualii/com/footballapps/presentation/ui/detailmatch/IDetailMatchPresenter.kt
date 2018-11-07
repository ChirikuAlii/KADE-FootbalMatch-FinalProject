package chirikualii.com.footballapps.presentation.ui.detailmatch

import chirikualii.com.footballapps.presentation.model.Event

/**
 * Created by chirikualii on {DATE}
 */
interface IDetailMatchPresenter {
    fun performInsertEvent(event : Event?)
    fun performDeleteEvent(idEvent: String?)
    fun performLoadTeamBadge(idTeam: String?, key: String)
    fun performCheckDataInDb(idEvent: String?)
}