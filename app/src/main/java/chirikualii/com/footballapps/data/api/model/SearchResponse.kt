package chirikualii.com.footballapps.data.api.model

import com.google.gson.annotations.SerializedName

/**
 * Created by chirikualii on {DATE}
 */
data class SearchResponse(
    @SerializedName("event") var matches: List<MatchModel>
)