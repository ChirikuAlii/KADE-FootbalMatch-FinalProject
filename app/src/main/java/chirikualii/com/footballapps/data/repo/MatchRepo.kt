package chirikualii.com.footballapps.data.repo

import chirikualii.com.footballapps.data.api.ApiService
import chirikualii.com.footballapps.data.local.dao.MatchDao
import chirikualii.com.footballapps.data.local.entity.MatchEntity
import chirikualii.com.footballapps.presentation.model.Match
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class MatchRepo @Inject constructor(val service: ApiService, val dao: MatchDao) {


    fun loadNextMatchList(id: String?): Flowable<List<Match>> =
        service.getUpcomingMatch(id)
            .flatMap {
                Flowable.fromIterable(it.matches)
            }
            .map {
                Match(
                    idTeamHome = it.idHomeTeam,
                    idTeamAway = it.idAwayTeam,
                    idMatch = it.idEvent,
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

    fun loadPrevMatchList(id: String?): Flowable<List<Match>> =
        service.getPasthMatch(id)
            .flatMap {
                Flowable.fromIterable(it.matches)
            }
            .map {
                Match(
                    idTeamHome = it.idHomeTeam,
                    idTeamAway = it.idAwayTeam,
                    dateMatch = it.dateEvent,
                    idMatch = it.idEvent,
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

    fun loadResultSearch(query : String?) :Flowable<List<Match>>{
        return service.searchMatch(query)
            .flatMap { Flowable.fromIterable(it.matches) }
            .map {
                Match(
                    idTeamHome = it.idHomeTeam,
                    idTeamAway = it.idAwayTeam,
                    dateMatch = it.dateEvent,
                    idMatch = it.idEvent,
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

    fun loadMatchFavorite(): Flowable<List<Match>>{
        val data = dao.getAllMatch()
        val result : ArrayList<Match> = ArrayList()
        for (it in data){
            result.add(
                Match(
                    idTeamHome = it.idTeamHome,
                    idTeamAway = it.idTeamAway,
                    dateMatch = it.dateMatch,
                    idMatch = it.idMatch,
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

    fun insertMatch(match: Match) {
        return dao.insertMatch(match = MatchEntity(
            idTeamHome = match.idTeamHome,
            idTeamAway = match.idTeamAway,
            dateMatch = match.dateMatch,
            idMatch = match.idMatch,
            homeTeamName = match.homeTeamName,
            homeDefender = match.homeDefender,
            homeGoalkepeer = match.homeGoalkepeer,
            homeDetailGoals = match.homeDetailGoals,
            homeFoward = match.homeFoward,
            homeMidfield = match.homeMidfield,
            homeScore = match.homeScore,
            awayTeamName = match.awayTeamName,
            awayDefender = match.awayDefender,
            awayGoalkepeer = match.awayGoalkepeer,
            awayDetailGoals = match.awayDetailGoals,
            awayFoward = match.awayFoward,
            awayMidfield = match.awayMidfield,
            awayScore = match.awayScore
        ))

    }

    fun deleteMatch(idMatch: String?){
        return dao.deleteMatch(idMatch)
    }

    fun checkMatchInDb(idMatch: String?):Observable<Boolean> {
       val result = dao.checkDataMatch(idMatch)

        return Observable.just(result.isNotEmpty())
    }

}