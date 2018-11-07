package chirikualii.com.footballapps.presentation.ui.match.nextmatch

import chirikualii.com.footballapps.presentation.base.BaseView
import chirikualii.com.footballapps.presentation.model.Match

/**
 * Created by chirikualii on {DATE}
 */
interface INextMatchView : BaseView {
    fun setOnSuccessLoad(match: List<Match>)
}