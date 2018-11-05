package chirikualii.com.footballapps.presentation.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.common.DATA_MATCH
import chirikualii.com.footballapps.common.MATCH
import chirikualii.com.footballapps.common.toDate
import chirikualii.com.footballapps.presentation.model.Event
import chirikualii.com.footballapps.presentation.ui.match.detailmatch.DetailMatchActivity
import kotlinx.android.synthetic.main.item_match.view.*

/**
 * Created by chirikualii on {DATE}
 */
class RecyclerViewMatchAdapter(val events : List<Event>) : RecyclerView.Adapter<RecyclerViewMatchAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
       val view= LayoutInflater.from(parent.context).inflate(R.layout.item_match,parent,false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
       return events.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(events[position])
    }


    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(event: Event){
            itemView.txtDateMatch?.text = event.dateMatch?.toDate()

            itemView.txtHomeTeamName?.text = event.homeTeamName
            itemView.txtScoreHomeTeam?.text = event.homeScore


            itemView.txtAwayTeamName?.text = event.awayTeamName
            itemView.txtScoreAwayTeam?.text = event.awayScore
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailMatchActivity::class.java)
                intent.putExtra(DATA_MATCH, event)
                itemView.context.startActivity(intent)
            }
        }
    }
}