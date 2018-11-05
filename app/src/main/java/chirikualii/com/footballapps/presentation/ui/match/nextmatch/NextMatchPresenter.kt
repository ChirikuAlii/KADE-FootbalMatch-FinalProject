package chirikualii.com.footballapps.presentation.ui.match.nextmatch

import chirikualii.com.footballapps.common.logD
import chirikualii.com.footballapps.common.toJsonElement
import chirikualii.com.footballapps.data.repo.EventsRepo
import chirikualii.com.footballapps.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class NextMatchPresenter @Inject constructor(val repo: EventsRepo): BasePresenter<INextMatchView>(),
    INextMatchPresenter {
    private val TAG = NextMatchPresenter::class.java.simpleName.toString()
    override fun performLoadData(leagueId : String) {


            view?.showProgress(true)

            disposables.add(
                repo.loadNextMatchList(leagueId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnComplete { view?.showProgress(false) }
                    .subscribe({
                        logD(TAG, "next match list : ${toJsonElement(it)}")
                        view?.setOnSuccessLoad(it)
                    }, {
                        view?.showMessage(it.message)
                    })
            )

        }

}