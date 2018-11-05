package chirikualii.com.footballapps.presentation.ui.match

import chirikualii.com.footballapps.presentation.base.BaseView
import chirikualii.com.footballapps.presentation.model.Event

/**
 * Created by chirikualii on {DATE}
 */
interface IMatchView :BaseView {
    fun navigateToResultSearchActivity(event : ArrayList<Event>)
}