package chirikualii.com.footballapps.data.api

import chirikualii.com.footballapps.BuildConfig
import chirikualii.com.footballapps.data.api.model.MatchResponse
import chirikualii.com.footballapps.data.api.model.PlayersResponse
import chirikualii.com.footballapps.data.api.model.SearchResponse
import chirikualii.com.footballapps.data.api.model.TeamsResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by chirikualii on {DATE}
 */
interface ApiService {

    @GET("api/v1/json/" + BuildConfig.TSDB_API_KEY + "/eventsnextleague.php")
    fun getUpcomingMatch(
        @Query("id") id: String?

    ): Flowable<MatchResponse>

    @GET("api/v1/json/" + BuildConfig.TSDB_API_KEY + "/eventspastleague.php")
    fun getPasthMatch(
        @Query("id") id: String?
    ): Flowable<MatchResponse>


    @GET("api/v1/json/" + BuildConfig.TSDB_API_KEY + "/lookupteam.php")
    fun getTeamBadge(
        @Query("id") idTeam: String?
    ): Flowable<TeamsResponse>

    @GET("api/v1/json/"+BuildConfig.TSDB_API_KEY + "/lookup_all_teams.php")
    fun getTeams(
        @Query("id")idLeague : String?
    ): Flowable<TeamsResponse>

    @GET("/api/v1/json/"+BuildConfig.TSDB_API_KEY +"/lookup_all_players.php")
    fun getPlayersTeam(
        @Query("id") idTeam :String?
    ) : Flowable<PlayersResponse>

    @GET("/api/v1/json/"+ BuildConfig.TSDB_API_KEY + "/searchevents.php")
    fun searchMatch(
        @Query("e")query : String?
    ) : Flowable<SearchResponse>
    @GET("/api/v1/json/"+BuildConfig.TSDB_API_KEY + "/searchteams.php")
    fun searchTeam(
        @Query("t") query: String?
    ) : Flowable<TeamsResponse>
}
