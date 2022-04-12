package com.example.quizapp.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.R
import com.example.quizapp.adapters.HistoryAdapter
import com.example.quizapp.adapters.PlayerApp
import com.example.quizapp.data.PlayerDao
import com.example.quizapp.data.models.Player
import com.example.quizapp.databinding.ActivityHistoryBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.tbHistory)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.tbHistory.setNavigationOnClickListener {
            onBackPressed()
        }

        val playerDao = (application as PlayerApp).db.playerDao()

        lifecycleScope.launch {
            playerDao.fetchAll().collect {
                val list = ArrayList(it)
                setRecycleView(list, playerDao)
            }
        }
    }
    //populates the recycler view using scores in player db
    private fun setRecycleView(list: ArrayList<Player>, playerDao: PlayerDao){
        if (list.isNotEmpty()){
            binding.rvHistory.visibility = View.VISIBLE
            val historyAdapter = HistoryAdapter(
                items = list,
            ){ player , pos -> deleteScoreFromDb(player, playerDao, pos) }
            binding.rvHistory.layoutManager = LinearLayoutManager(this)
            binding.rvHistory.adapter = historyAdapter
        }else {
            binding.rvHistory.visibility = View.INVISIBLE
        }
    }

    //delete item from the db confirms with user first using alert dialog
    private fun deleteScoreFromDb(player: Player, playerDao: PlayerDao, pos: Int){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete History")
            .setPositiveButton("Confirm"){
                    dialogInter, _ ->
                lifecycleScope.launch {
                    playerDao.delete(
                        player
                    )
                    Toast.makeText(this@HistoryActivity,"item has been deleted", Toast.LENGTH_LONG).show()
                    dialogInter.dismiss()
                    if (pos == 0){
                        binding.rvHistory.visibility = View.INVISIBLE
                    }
                }
            }
            .setNegativeButton("Cancel"){
                    dialog,_ -> dialog.dismiss()
            }
            .setMessage("previous history can not be recovered after " +
                    "being deleted are you sure you wish to continue")
            .setIcon(
                ContextCompat.getDrawable(this, R.drawable.ic_baseline_warning_24)
            )
        val alertDialog = builder.create()
        alertDialog.show()
    }
}