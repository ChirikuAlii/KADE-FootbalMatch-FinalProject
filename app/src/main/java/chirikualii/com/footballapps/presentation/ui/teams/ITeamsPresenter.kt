package chirikualii.com.footballapps.presentation.ui.teams

/**
 * Created by chirikualii on {DATE}
 */
interface ITeamsPresenter {
    fun performLoadData(idLeague : String)
    fun performSearch(query : String?)
}