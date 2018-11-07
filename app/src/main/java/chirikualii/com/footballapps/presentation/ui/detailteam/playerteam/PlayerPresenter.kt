package chirikualii.com.footballapps.presentation.ui.detailteam.playerteam

import chirikualii.com.footballapps.common.logD
import chirikualii.com.footballapps.common.toJsonElement
import chirikualii.com.footballapps.data.repo.PlayersRepo
import chirikualii.com.footballapps.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class PlayerPresenter @Inject constructor(val repo: PlayersRepo) : BasePresenter<IPlayerView>(), IPlayerPresenter {

    val TAG = PlayerPresenter::class.java.simpleName
    override fun perfromLoadData(idTeam: String?) {
        view?.showProgress(true)
        disposables.add(
            repo.loadPlayersList(idTeam)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete {
                    view?.showProgress(false)
                }
                .subscribe({
                    logD(TAG, "data player : ${toJsonElement(it)}")
                    view?.showPlayersList(it)
                }, {
                    view?.showMessage(it.message)
                })
        )
    }
}