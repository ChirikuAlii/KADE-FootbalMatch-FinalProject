package chirikualii.com.footballapps.presentation.ui.detailteam

import chirikualii.com.footballapps.presentation.base.BaseView

/**
 * Created by chirikualii on 11/7/18
 * github.com/chirikualii
 */
interface IDetailTeamView : BaseView {
    fun addedToFavorite()
    fun deletedFromFavorite()
    fun savedAsFavorite(isFavorite: Boolean)
}