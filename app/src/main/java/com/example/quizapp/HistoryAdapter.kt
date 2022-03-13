package com.example.quizapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.databinding.HistoryRowBinding

class HistoryAdapter(
    private val items: ArrayList<Player>
) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    class ViewHolder(binding: HistoryRowBinding): RecyclerView.ViewHolder(binding.root){
        val llMain = binding.llMain
        val tvName = binding.tvName
        val tvScore = binding.tvScore

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            binding = HistoryRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.tvName.text = item.playerName
        holder.tvScore.text = item.score.toString()

        holder.llMain.setBackgroundColor(
            if (position % 2 == 0) Color.LTGRAY else Color.WHITE
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

}