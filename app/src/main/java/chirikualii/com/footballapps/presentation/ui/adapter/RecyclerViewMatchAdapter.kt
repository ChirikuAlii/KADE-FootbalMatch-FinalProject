package chirikualii.com.footballapps.presentation.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import chirikualii.com.footballapps.R
import chirikualii.com.footballapps.common.DATA_MATCH
import chirikualii.com.footballapps.common.toDate
import chirikualii.com.footballapps.presentation.model.Match
import chirikualii.com.footballapps.presentation.ui.detailmatch.DetailMatchActivity
import kotlinx.android.synthetic.main.item_match.view.*

/**
 * Created by chirikualii on {DATE}
 */
class RecyclerViewMatchAdapter(val matches: List<Match>) : RecyclerView.Adapter<RecyclerViewMatchAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return matches.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(matches[position])
    }


    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(match: Match) {
            itemView.txtDateMatch?.text = match.dateMatch?.toDate()

            itemView.txtHomeTeamName?.text = match.homeTeamName
            itemView.txtScoreHomeTeam?.text = match.homeScore


            itemView.txtAwayTeamName?.text = match.awayTeamName
            itemView.txtScoreAwayTeam?.text = match.awayScore
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailMatchActivity::class.java)
                intent.putExtra(DATA_MATCH, match)
                itemView.context.startActivity(intent)
            }
        }
    }
}