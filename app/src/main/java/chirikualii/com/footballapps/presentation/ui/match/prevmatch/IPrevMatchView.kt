package chirikualii.com.footballapps.presentation.ui.match.prevmatch

import chirikualii.com.footballapps.presentation.base.BaseView
import chirikualii.com.footballapps.presentation.model.Match

/**
 * Created by chirikualii on {DATE}
 */
interface IPrevMatchView : BaseView {
    fun setOnSuccessLoad(match: List<Match>)
}