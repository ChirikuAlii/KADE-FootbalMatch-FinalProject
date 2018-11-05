package chirikualii.com.footballapps.presentation.ui.match

import chirikualii.com.footballapps.common.logD
import chirikualii.com.footballapps.common.toJsonElement
import chirikualii.com.footballapps.data.repo.MatchRepo
import chirikualii.com.footballapps.presentation.base.BasePresenter
import chirikualii.com.footballapps.presentation.model.Event
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class MatchPresenter @Inject constructor(val repo : MatchRepo) : BasePresenter<IMatchView>(), IMatchPresenter {

    val TAG = MatchPresenter::class.java.simpleName
    val events = ArrayList<Event>()

    override fun performSearch(query: String?) {
        view?.showProgress(true)
        disposables.add(
            repo.loadResultSearch(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete {
                    view?.showProgress(false)
                }
                .subscribe ({
                    logD(TAG,"result search: ${toJsonElement(it)}")
                    for (event in it){
                        events.add(event)
                    }
                    view?.navigateToResultSearchActivity(events)
                    events.clear()
                },{
                    view?.showMessage(it.message)
                })
        )


    }
}