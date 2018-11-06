package chirikualii.com.footballapps.data.api.model

import com.google.gson.annotations.SerializedName

data class PlayersResponse(
    @SerializedName("player")
    val player: List<PlayerModel>
)