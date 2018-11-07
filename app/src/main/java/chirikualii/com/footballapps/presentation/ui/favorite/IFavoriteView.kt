package chirikualii.com.footballapps.presentation.ui.favorite

import chirikualii.com.footballapps.presentation.base.BaseView
import chirikualii.com.footballapps.presentation.model.Event

/**
 * Created by chirikualii on {DATE}
 */
interface IFavoriteView :BaseView {
    fun showFavorite(event : List<Event>)
}