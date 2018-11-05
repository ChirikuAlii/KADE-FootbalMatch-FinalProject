package chirikualii.com.footballapps.presentation.ui.match.nextmatch

import chirikualii.com.footballapps.presentation.base.BaseView
import chirikualii.com.footballapps.presentation.model.Event

/**
 * Created by chirikualii on {DATE}
 */
interface INextMatchView :BaseView {
    fun setOnSuccessLoad(event: List<Event>)
}