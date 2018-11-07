package chirikualii.com.footballapps.presentation.ui.favorite

import chirikualii.com.footballapps.common.logD
import chirikualii.com.footballapps.common.toJsonElement
import chirikualii.com.footballapps.data.local.dao.MatchDao
import chirikualii.com.footballapps.data.repo.EventsRepo
import chirikualii.com.footballapps.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class FavoritePresenter @Inject constructor(val eventsRepo: EventsRepo):BasePresenter<IFavoriteView>() ,IFavoritePresenter {
    override fun performLoadData() {
        disposables.add(
            eventsRepo.loadMatchFavorite()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    logD("DATABASE", "data : ${toJsonElement(it)}")
                    view?.showFavorite(it)

                },{
                    view?.showMessage(it.message)
                })
        )

    }
}