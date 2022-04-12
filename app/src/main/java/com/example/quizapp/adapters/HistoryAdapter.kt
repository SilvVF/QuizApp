package com.example.quizapp.adapters

import android.graphics.Color
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.data.models.Player
import com.example.quizapp.databinding.HistoryRowBinding
//adapter for recyclerview that holds previous scored
class HistoryAdapter(
    private val items: ArrayList<Player>,
    private val deleteListener:(player: Player , pos : Int) -> Unit  //function contained in history activity
) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    class ViewHolder(binding: HistoryRowBinding): RecyclerView.ViewHolder(binding.root){
        val llMain = binding.llMain
        val tvName = binding.tvName
        val tvScore = binding.tvScore
        val ibDelete = binding.ibDelete
        //var root = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            binding = HistoryRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.ibDelete.setOnClickListener {
            deleteListener.invoke(item , position)
        }
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