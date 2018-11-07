package chirikualii.com.footballapps.presentation.ui.detailteam

import chirikualii.com.footballapps.common.logD
import chirikualii.com.footballapps.common.toJsonElement
import chirikualii.com.footballapps.data.repo.TeamsRepo
import chirikualii.com.footballapps.presentation.base.BasePresenter
import chirikualii.com.footballapps.presentation.model.Team
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by chirikualii on 11/7/18
 * github.com/chirikualii
 */
class DetailTeamPresenter @Inject constructor(val repo: TeamsRepo) : BasePresenter<IDetailTeamView>(),
    IDetailTeamPresenter {

    val TAG = DetailTeamPresenter::class.java.simpleName
    override fun performInsertTeam(team: Team?) {
        disposables.add(
            Flowable.fromCallable {
                repo.insertTeam(team)
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    logD(TAG, "data berhasil diinput ${toJsonElement(it)}")
                    view?.addedToFavorite()
                }, {
                    view?.showMessage(it.message)
                })

        )
    }


    override fun performDeleteTeam(idTeam: String?) {
        disposables.add(
            Flowable.fromCallable {
                repo.deleteTeam(idTeam)
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    logD(TAG, "data dengan idTeam ${idTeam}  telah di hapus")
                    view?.deletedFromFavorite()
                }, {
                    view?.showMessage(it.message)
                })
        )
    }

    override fun performCheckInDb(idTeam: String?) {
        disposables.add(
            repo.checkTeamInDb(idTeam)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.savedAsFavorite(it)
                }, {
                    view?.showMessage(it.message)
                })
        )
    }
}