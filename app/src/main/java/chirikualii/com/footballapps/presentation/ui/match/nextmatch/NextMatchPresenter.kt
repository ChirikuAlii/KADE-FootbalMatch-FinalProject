package chirikualii.com.footballapps.presentation.ui.match.nextmatch

import chirikualii.com.footballapps.common.logD
import chirikualii.com.footballapps.common.toJsonElement
import chirikualii.com.footballapps.data.repo.MatchRepo
import chirikualii.com.footballapps.presentation.base.BasePresenter
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class NextMatchPresenter @Inject constructor(val repo: MatchRepo) : BasePresenter<INextMatchView>(),
    INextMatchPresenter {
    private val TAG = NextMatchPresenter::class.java.simpleName.toString()
    override fun performLoadData(leagueId: String) {


        view?.showProgress(true)

        disposables.add(
            repo.loadNextMatchList(leagueId)
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
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