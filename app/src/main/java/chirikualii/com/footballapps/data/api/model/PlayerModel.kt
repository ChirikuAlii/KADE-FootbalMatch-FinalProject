package chirikualii.com.footballapps.data.api.model

import com.google.gson.annotations.SerializedName

data class PlayerModel(
    @SerializedName("dateBorn")
    val dateBorn: String?="",
    @SerializedName("dateSigned")
    val dateSigned: String? ="",
    @SerializedName("idPlayer")
    val idPlayer: String?="",
    @SerializedName("idPlayerManager")
    val idPlayerManager: String? ="",
    @SerializedName("idSoccerXML")
    val idSoccerXML: String?="",
    @SerializedName("idTeam")
    val idTeam: String?="",
    @SerializedName("intLoved")
    val intLoved: String?="",
    @SerializedName("intSoccerXMLTeamID")
    val intSoccerXMLTeamID: String?="",
    @SerializedName("strBanner")
    val strBanner: String?="",
    @SerializedName("strBirthLocation")
    val strBirthLocation: String?="",
    @SerializedName("strCollege")
    val strCollege: String?="",
    @SerializedName("strCutout")
    val strCutout: String?="",
    @SerializedName("strDescriptionCN")
    val strDescriptionCN: String?="",
    @SerializedName("strDescriptionDE")
    val strDescriptionDE: String?="",
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String?="",
    @SerializedName("strDescriptionES")
    val strDescriptionES: String?="",
    @SerializedName("strDescriptionFR")
    val strDescriptionFR: String?="",
    @SerializedName("strDescriptionHU")
    val strDescriptionHU: String?="",
    @SerializedName("strDescriptionIL")
    val strDescriptionIL: String?="",
    @SerializedName("strDescriptionIT")
    val strDescriptionIT: String?="",
    @SerializedName("strDescriptionJP")
    val strDescriptionJP: String?="",
    @SerializedName("strDescriptionNL")
    val strDescriptionNL: String?="",
    @SerializedName("strDescriptionNO")
    val strDescriptionNO: String?="",
    @SerializedName("strDescriptionPL")
    val strDescriptionPL: String?="",
    @SerializedName("strDescriptionPT")
    val strDescriptionPT: String?="",
    @SerializedName("strDescriptionRU")
    val strDescriptionRU: String?="",
    @SerializedName("strDescriptionSE")
    val strDescriptionSE: String?="",
    @SerializedName("strFacebook")
    val strFacebook: String?="",
    @SerializedName("strFanart1")
    val strFanart1: String?="",
    @SerializedName("strFanart2")
    val strFanart2: String?="",
    @SerializedName("strFanart3")
    val strFanart3: String?="",
    @SerializedName("strFanart4")
    val strFanart4: String?="",
    @SerializedName("strGender")
    val strGender: String?="",
    @SerializedName("strHeight")
    val strHeight: String?="",
    @SerializedName("strInstagram")
    val strInstagram: String?="",
    @SerializedName("strLocked")
    val strLocked: String?="",
    @SerializedName("strNationality")
    val strNationality: String?="",
    @SerializedName("strPlayer")
    val strPlayer: String?="",
    @SerializedName("strPosition")
    val strPosition: String?="",
    @SerializedName("strSigning")
    val strSigning: String?="",
    @SerializedName("strSport")
    val strSport: String?="",
    @SerializedName("strTeam")
    val strTeam: String?="",
    @SerializedName("strThumb")
    val strThumb: String?="",
    @SerializedName("strTwitter")
    val strTwitter: String?="",
    @SerializedName("strWage")
    val strWage: String?="",
    @SerializedName("strWebsite")
    val strWebsite: String?="",
    @SerializedName("strWeight")
    val strWeight: String?="",
    @SerializedName("strYoutube")
    val strYoutube: String?=""
)