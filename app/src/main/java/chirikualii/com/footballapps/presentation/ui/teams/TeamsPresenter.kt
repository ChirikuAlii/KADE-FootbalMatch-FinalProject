package chirikualii.com.footballapps.presentation.ui.teams

import chirikualii.com.footballapps.common.logD
import chirikualii.com.footballapps.common.toJsonElement
import chirikualii.com.footballapps.data.repo.MatchRepo
import chirikualii.com.footballapps.data.repo.TeamsRepo
import chirikualii.com.footballapps.presentation.base.BasePresenter
import chirikualii.com.footballapps.presentation.model.Team
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class TeamsPresenter @Inject constructor(val repo :TeamsRepo) : BasePresenter<ITeamsView>() , ITeamsPresenter {
    val TAG = TeamsPresenter::class.java.simpleName
    val teams = ArrayList<Team>()
    override fun performSearch(query: String?) {
        disposables.add(
            repo.loadResultSearch(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    logD(TAG,"result search: ${toJsonElement(it)}")
                    for (team in it ){
                        teams.add(team)
                    }
                    view?.navigateToResultSearcActivity(teams)
                    teams.clear()
                },{
                    view?.showMessage(it.message)
                })
        )
    }

    override fun performLoadData(idLeague: String) {
        view?.showProgress(true)
        disposables.add(
            repo.loadTeams(idLeague)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete { view?.showProgress(false) }
                .subscribe({
                    view?.showLoadData(it)
                    logD(TAG, "data: ${toJsonElement(it)}")
                },{
                    view?.showMessage(it.message)
                })
        )
    }
}