package com.example.madlevel4task22.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel4task22.R
import com.example.madlevel4task22.model.Game
import kotlinx.android.synthetic.main.item_resultaat.view.*


class Adapter(private val games: List<Game>):
    RecyclerView.Adapter<Adapter.ViewHolder>()
{
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        val binding = ItemReminderBinding.bind(itemView)

        fun databind(game: Game){
//            binding.tvReminder.text = reminder.reminderText
            itemView.tvDatum.text = game.datePlayed.toString()
            itemView.tvResults.text = game.result
            itemView.Keuzecomputer.setImageResource(game.pcMove)
            itemView.KeuzeSpeler.setImageResource(game.playerMove)
        }
    }



    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_resultaat,parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return games.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(games[position])
    }
}