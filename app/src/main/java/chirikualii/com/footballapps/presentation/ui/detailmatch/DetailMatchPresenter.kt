package chirikualii.com.footballapps.presentation.ui.detailmatch

import chirikualii.com.footballapps.common.logD
import chirikualii.com.footballapps.common.toJsonElement
import chirikualii.com.footballapps.data.local.dao.MatchDao
import chirikualii.com.footballapps.data.repo.DetailMatchRepo
import chirikualii.com.footballapps.data.repo.EventsRepo
import chirikualii.com.footballapps.presentation.base.BasePresenter
import chirikualii.com.footballapps.presentation.model.Event
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class DetailMatchPresenter @Inject constructor
    (val repo:DetailMatchRepo, val eventRepo: EventsRepo, val dao: MatchDao): BasePresenter<IDetailMatchView>() ,IDetailMatchPresenter{

    var message = ""
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

    override fun performInsertEvent(event: Event?) {
        disposables.add(
            Observable.fromCallable {
                eventRepo.insertMatch(event!!)
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    logD(TAG,"InsertData Berhasil")
                    view?.addedToFavorite()
                },{
                    view?.showMessage(it.message)
                })
        )

    }

    override fun performDeleteEvent(idEvent: String?) {
        disposables.add(
            Observable.fromCallable {
                eventRepo.deleteMatch(idEvent)
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    logD(TAG,"Delete Data Berhasil")

                    view?.deletedFromFavorite()
                },{
                    view?.showMessage(it.message)
                })
        )
    }

    fun performLoadFavortie (){

    }


}