package chirikualii.com.footballapps.presentation.ui.match.detailmatch

import chirikualii.com.footballapps.common.logD
import chirikualii.com.footballapps.common.toJsonElement
import chirikualii.com.footballapps.data.repo.DetailMatchRepo
import chirikualii.com.footballapps.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class DetailMatchPresenter @Inject constructor(val repo:DetailMatchRepo): BasePresenter<IDetailMatchView>() ,IDetailMatchPresenter{

    val TAG = DetailMatchPresenter::class.java.simpleName
    override fun performLoadTeamBadge(idTeam: String?, key: String) {

        disposables.add(
            repo.loadDetailTeam(idTeam)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    logD(TAG, "Team Badge: ${toJsonElement(it)}")
                    when (key) {
                        "Home" -> {
                            view?.showTeamBadgeHome(it[0].badgeTeam)
                        }

                        "Away" -> {
                            view?.showTeamBadgeAway(it[0].badgeTeam)
                        }
                    }
                }, {
                    view?.showMessage(it.message)
                })
        )
    }

    override fun performCheckDataInDb(idEvent: String?) {

    }
}