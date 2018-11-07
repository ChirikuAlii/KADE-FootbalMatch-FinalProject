package chirikualii.com.footballapps.presentation.ui.detailmatch

import chirikualii.com.footballapps.common.logD
import chirikualii.com.footballapps.common.toJsonElement
import chirikualii.com.footballapps.data.local.dao.MatchDao
import chirikualii.com.footballapps.data.repo.DetailMatchRepo
import chirikualii.com.footballapps.data.repo.MatchRepo
import chirikualii.com.footballapps.presentation.base.BasePresenter
import chirikualii.com.footballapps.presentation.model.Match
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class DetailMatchPresenter @Inject constructor
    (val repo: DetailMatchRepo, val matchRepo: MatchRepo, val dao: MatchDao) : BasePresenter<IDetailMatchView>(),
    IDetailMatchPresenter {

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

    override fun performCheckDataInDb(idMatch: String?) {
        disposables.add(
            matchRepo.checkMatchInDb(idMatch)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.savedAsFavorite(it)
                }, {
                    view?.showMessage(it.message)
                })
        )
    }

    override fun performInsertMatch(match: Match?) {
        disposables.add(
            Observable.fromCallable {
                matchRepo.insertMatch(match!!)
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    logD(TAG, "InsertData Berhasil")
                    view?.addedToFavorite()
                }, {
                    view?.showMessage(it.message)
                })
        )

    }

    override fun performDeleteMatch(idMatch: String?) {
        disposables.add(
            Observable.fromCallable {
                matchRepo.deleteMatch(idMatch)
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    logD(TAG, "Delete Data Berhasil")
                    view?.deletedFromFavorite()
                }, {
                    view?.showMessage(it.message)
                })
        )
    }


}