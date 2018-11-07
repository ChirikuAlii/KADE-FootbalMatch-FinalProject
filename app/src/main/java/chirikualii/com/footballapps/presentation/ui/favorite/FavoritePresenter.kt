package chirikualii.com.footballapps.presentation.ui.favorite

import chirikualii.com.footballapps.common.logD
import chirikualii.com.footballapps.common.toJsonElement
import chirikualii.com.footballapps.data.repo.MatchRepo
import chirikualii.com.footballapps.data.repo.TeamsRepo
import chirikualii.com.footballapps.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class FavoritePresenter @Inject constructor(val matchRepo: MatchRepo, val teamsRepo: TeamsRepo):BasePresenter<IFavoriteView>() ,IFavoritePresenter {
    val TAG = FavoritePresenter::class.java.simpleName
    override fun performLoadData(key :String?) {

        when (key){

            FavoriteMatchFragment::class.java.simpleName -> {
                disposables.add(
                    matchRepo.loadMatchFavorite()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            logD(TAG, "Data match : ${toJsonElement(it)}")
                            view?.showFavorite(it)

                        },{
                            view?.showMessage(it.message)
                        })
                )
            }

            FavoriteTeamFragment::class.java.simpleName -> {
                disposables.add(
                    teamsRepo.loadTeamFavorite()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            logD(TAG,"Data team: ${toJsonElement(it)}")
                            view?.showFavorite(it)
                        },{
                            view?.showMessage(it.message)
                        })
                )
            }
        }


    }
}