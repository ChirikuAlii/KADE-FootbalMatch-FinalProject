package chirikualii.com.footballapps.data.repo

import chirikualii.com.footballapps.data.api.ApiService
import chirikualii.com.footballapps.presentation.model.Team
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class DetailMatchRepo @Inject constructor(val service: ApiService) {

    fun loadDetailTeam(idTeam: String?): Flowable<List<Team>> =
        service.getTeamBadge(idTeam)
            .flatMap {
                Flowable.fromIterable(it.teamModels)
            }
            .map {
                Team(
                    idTeam = it.idTeam,
                    badgeTeam = it.strTeamBadge
                )
            }
            .toList()
            .toFlowable()

}