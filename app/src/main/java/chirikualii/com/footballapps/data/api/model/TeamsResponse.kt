package chirikualii.com.footballapps.data.api.model

import com.google.gson.annotations.SerializedName

/**
 * Created by chirikualii on {DATE}
 */
data class TeamsResponse(
    @SerializedName("teams") var teamModels: List<TeamModel> = listOf()
)