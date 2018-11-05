package chirikualii.com.footballapps.presentation.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.presentation.model.Team
import chirikualii.com.footballapps.presentation.ui.teams.detailteam.DetailTeamActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_team.view.*

/**
 * Created by chirikualii on {DATE}
 */
class RecyclerViewTeamAdapter(val teamList: List<Team>) : RecyclerView.Adapter<RecyclerViewTeamAdapter.Holder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_team,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
     return teamList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(teamList[position])
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(team: Team) {

            itemView.txtTeamName?.text = team.teamName

            Glide.with(itemView)
                .load(team.badgeTeam)
                .into(itemView.imgTeam)

            itemView.setOnClickListener {
                //pindah halaman
                Intent(itemView.context,DetailTeamActivity::class.java).apply {
                    itemView.context.startActivity(this)
                }
            }

        }


    }
}