package chirikualii.com.footballapps.presentation.ui.match.prevmatch

import chirikualii.com.footballapps.common.logD
import chirikualii.com.footballapps.common.toJsonElement
import chirikualii.com.footballapps.data.repo.MatchRepo
import chirikualii.com.footballapps.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class PrevMatchPresenter @Inject constructor(val repo : MatchRepo) : BasePresenter<IPrevMatchView>() ,
    IPrevMatchPresenter {
    private val TAG = PrevMatchPresenter::class.java.simpleName.toString()
    override fun performLoadData(leagueId :String) {
            view?.showProgress(true)

            disposables.add(
                repo.loadPrevMatchList(leagueId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnComplete { view?.showProgress(false) }
                    .subscribe({
                        logD(TAG, "prev match list : ${toJsonElement(it)}")
                        view?.setOnSuccessLoad(it)
                    }, {
                        view?.showMessage(it.message)
                    })
            )

        }
}