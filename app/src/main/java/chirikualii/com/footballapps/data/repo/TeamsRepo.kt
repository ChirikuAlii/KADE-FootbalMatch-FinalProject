package chirikualii.com.footballapps.data.repo

import chirikualii.com.footballapps.data.api.ApiService
import chirikualii.com.footballapps.presentation.model.Team
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class TeamsRepo @Inject constructor(val service: ApiService) {

    fun loadTeams(idLeague: String): Flowable<List<Team>> {

        return service.getTeams(idLeague)
            .flatMap {
                Flowable.fromIterable(it.teamModels)
            }
            .map {
                Team(
                    idTeam = it.idTeam,
                    badgeTeam = it.strTeamBadge,
                    formedYear = it.intFormedYear,
                    stadiumName = it.strStadium,
                    overview = it.strDescriptionEN,
                    teamName = it.strTeam
                )
            }
            .toList()
            .toFlowable()

    }
    fun loadResultSearch(query : String?) : Flowable<List<Team>> {
        return service.searchTeam(query)
            .flatMap {
                Flowable.fromIterable(it.teamModels)
            }
            .map {
                Team(
                    idTeam = it.idTeam,
                    badgeTeam = it.strTeamBadge,
                    formedYear = it.intFormedYear,
                    stadiumName = it.strStadium,
                    overview = it.strDescriptionEN,
                    teamName = it.strTeam
                )
            }
            .toList()
            .toFlowable()
    }

}