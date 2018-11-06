package chirikualii.com.footballapps.data.repo

import chirikualii.com.footballapps.data.api.ApiService
import chirikualii.com.footballapps.presentation.model.Player
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by chirikualii on {DATE}
 */
class PlayersRepo @Inject constructor(val service : ApiService) {

    fun loadPlayersList(idTeam : String?) : Flowable<List<Player>>{
        return service.getPlayersTeam(idTeam)
            .flatMap { Flowable.fromIterable(it.player) }
            .map {
                Player(
                    idPlayer = it.idPlayer,
                    namePlayer = it.strPlayer,
                    weightPlayer = it.strWeight,
                    heightPlayer = it.strHeight,
                    positionPlayer = it.strPosition,
                    overviewPlayer = it.strDescriptionEN,
                    imgPlayer = it.strCutout.toString(),
                    imgPosterPlayer = it.strFanart1.toString()
                )
            }
            .toList()
            .toFlowable()
    }
}