package chirikualii.com.footballapps.presentation.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.common.DATA_DETAIL_PLAYERS
import chirikualii.com.footballapps.presentation.model.Player
import chirikualii.com.footballapps.presentation.ui.detailteam.detailplayerteam.DetailPlayerActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_player.view.*

/**
 * Created by chirikualii on {DATE}
 */
class RecyclerViewPlayerAdapter(val playerList: List<Player>) :
    RecyclerView.Adapter<RecyclerViewPlayerAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(playerList[position])
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(player: Player?) {

            Glide.with(itemView)
                .load(player?.imgPlayer)
                .into(itemView.imgPlayer)

            itemView.txtPlayerName.text = player?.namePlayer
            itemView.txtPlayerPosition.text = player?.positionPlayer

            itemView.setOnClickListener {
                Intent(itemView.context, DetailPlayerActivity::class.java).apply {
                    putExtra(DATA_DETAIL_PLAYERS, player)
                    itemView.context.startActivity(this)
                }
            }
        }
    }
}