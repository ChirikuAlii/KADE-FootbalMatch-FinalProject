package chirikualii.com.footballapps.data.repo

import chirikualii.com.footballapps.data.api.ApiService
import chirikualii.com.footballapps.data.local.dao.MatchDao
import chirikualii.com.footballapps.data.local.entity.MatchEntity
import chirikualii.com.footballapps.presentation.model.Event
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class EventsRepo @Inject constructor(val service: ApiService ,val dao: MatchDao) {


    fun loadNextMatchList(id: String?): Flowable<List<Event>> =
        service.getUpcomingMatch(id)
            .flatMap {
                Flowable.fromIterable(it.events)
            }
            .map {
                Event(
                    idTeamHome = it.idHomeTeam,
                    idTeamAway = it.idAwayTeam,
                    idEvent = it.idEvent,
                    dateMatch = it.dateEvent,
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

    fun loadPrevMatchList(id: String?): Flowable<List<Event>> =
        service.getPasthMatch(id)
            .flatMap {
                Flowable.fromIterable(it.events)
            }
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

    fun loadMatchFavorite(): Flowable<List<Event>>{
        val data = dao.getAllMatch()
        val result : ArrayList<Event> = ArrayList()
        for (it in data){
            result.add(
                Event(
                    idTeamHome = it.idTeamHome,
                    idTeamAway = it.idTeamAway,
                    dateMatch = it.dateMatch,
                    idEvent = it.idEvent,
                    homeTeamName = it.homeTeamName,
                    homeDefender = it.homeDefender,
                    homeGoalkepeer = it.homeGoalkepeer,
                    homeDetailGoals = it.homeDetailGoals,
                    homeFoward = it.homeFoward,
                    homeMidfield = it.homeMidfield,
                    homeScore = it.homeScore,
                    awayTeamName = it.awayTeamName,
                    awayDefender = it.awayDefender,
                    awayGoalkepeer = it.awayGoalkepeer,
                    awayDetailGoals = it.awayDetailGoals,
                    awayFoward = it.awayFoward,
                    awayMidfield = it.awayMidfield,
                    awayScore = it.awayScore

                )
            )
        }
        return Flowable.just(result.toList())
    }

    fun insertMatch(event: Event) {
        return dao.insertMatch(match = MatchEntity(
            idTeamHome = event.idTeamHome,
            idTeamAway = event.idTeamAway,
            dateMatch = event.dateMatch,
            idEvent = event.idEvent,
            homeTeamName = event.homeTeamName,
            homeDefender = event.homeDefender,
            homeGoalkepeer = event.homeGoalkepeer,
            homeDetailGoals = event.homeDetailGoals,
            homeFoward = event.homeFoward,
            homeMidfield = event.homeMidfield,
            homeScore = event.homeScore,
            awayTeamName = event.awayTeamName,
            awayDefender = event.awayDefender,
            awayGoalkepeer = event.awayGoalkepeer,
            awayDetailGoals = event.awayDetailGoals,
            awayFoward = event.awayFoward,
            awayMidfield = event.awayMidfield,
            awayScore = event.awayScore
        ))

    }

    fun deleteMatch(idEvent: String?){
        return dao.deleteMatch(idEvent)
    }

    fun checkEventInDb(idEvent: String?):Observable<Boolean> {
       val result = dao.checkDataMatch(idEvent)

        return Observable.just(result.isNotEmpty())
    }

}