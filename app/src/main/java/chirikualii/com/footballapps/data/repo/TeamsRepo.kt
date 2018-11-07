package chirikualii.com.footballapps.data.repo

import chirikualii.com.footballapps.data.api.ApiService
import chirikualii.com.footballapps.data.local.dao.TeamDao
import chirikualii.com.footballapps.data.local.entity.TeamEntity
import chirikualii.com.footballapps.presentation.model.Team
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class TeamsRepo @Inject constructor(val service: ApiService, val dao: TeamDao) {

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

    fun loadResultSearch(query: String?): Flowable<List<Team>> {
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

    fun insertTeam(team: Team?) {
        return dao.insertTeam(
            team = TeamEntity(
                idTeam = team?.idTeam,
                badgeTeam = team?.badgeTeam,
                formedYear = team?.formedYear,
                stadiumName = team?.stadiumName,
                overview = team?.overview,
                teamName = team?.teamName
            )
        )
    }

    fun deleteTeam(idTeam: String?) {
        return dao.deleteTeam(idTeam)
    }

    fun loadTeamFavorite(): Flowable<List<Team>> {
        val data = dao.getAllTeam()
        val result: ArrayList<Team> = ArrayList()

        for (it in data) {
            result.add(
                Team(
                    idTeam = it.idTeam,
                    badgeTeam = it.badgeTeam,
                    formedYear = it.formedYear,
                    stadiumName = it.stadiumName,
                    overview = it.overview,
                    teamName = it.teamName
                )
            )
        }
        return Flowable.just(result.toList())
    }

    fun checkTeamInDb(idTeam: String?): Observable<Boolean> {
        val result = dao.checkTeamInDb(idTeam)

        return Observable.just(result.isNotEmpty())
    }
}