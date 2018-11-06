package chirikualii.com.footballapps.presentation.ui.detailteam.detailplayerteam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.common.DATA_DETAIL_PLAYERS
import chirikualii.com.footballapps.presentation.model.Player
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_player.*


class DetailPlayerActivity : AppCompatActivity() {

    var data: Player? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_player)
        data = intent.getParcelableExtra(DATA_DETAIL_PLAYERS)
        setupView()
    }

    private fun setupView() {
        toolbarLay.apply {
            title = getString(R.string.match)
            navigationIcon = ResourcesCompat.getDrawable(resources, R.drawable.ic_arrow_back, null)
            setNavigationOnClickListener {
                onBackPressed()

            }
            txtPositionPlayer.text = data?.positionPlayer
            txtHeightPlayer.text = data?.heightPlayer
            txtWeightPlayer.text = data?.weightPlayer
            txtOverviewPlayer.text = data?.overviewPlayer
            toolbarLay.title = data?.namePlayer

            Glide.with(this)
                .load(data?.imgPosterPlayer)
                .into(imgPosterPlayer)
        }
    }
}
