package chirikualii.com.footballapps.data.repo

import chirikualii.com.footballapps.data.api.ApiService
import chirikualii.com.footballapps.presentation.model.Event
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class MatchRepo @Inject constructor(val service : ApiService){
    fun loadResultSearch(query : String?) :Flowable<List<Event>>{
        return service.searchMatch(query)
            .flatMap { Flowable.fromIterable(it.events) }
            .map {
                Event(
                    idTeamHome = it.idHomeTeam,
                    idTeamAway = it.idAwayTeam,
                    dateMatch = it.dateEvent,
                    idEvent = it.idEvent,
                    homeTeamName = it.strHomeTeam,
                    homeDefender = it.strHomeLineupDefense,
                    homeGoalkepeer = it.strHomeLineupGoalkeeper,
                    homeDetailGoals = it.strHomeGoalDetails,
                    homeFoward = it.strHomeLineupForward,
                    homeMidfield = it.strHomeLineupMidfield,
                    homeScore = it.intHomeScore,
                    awayTeamName = it.strAwayTeam,
                    awayDefender = it.strAwayLineupDefense,
                    awayGoalkepeer = it.strAwayLineupGoalkeeper,
                    awayDetailGoals = it.strAwayGoalDetails,
                    awayFoward = it.strAwayLineupForward,
                    awayMidfield = it.strAwayLineupMidfield,
                    awayScore = it.intAwayScore
                )

            }
            .toList()
            .toFlowable()

    }
}