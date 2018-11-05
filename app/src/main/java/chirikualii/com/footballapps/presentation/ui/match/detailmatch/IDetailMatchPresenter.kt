package chirikualii.com.footballapps.presentation.ui.match.detailmatch

/**
 * Created by chirikualii on {DATE}
 */
interface IDetailMatchPresenter {
    fun performLoadTeamBadge(idTeam: String?, key: String)
    fun performCheckDataInDb(idEvent: String?)
}