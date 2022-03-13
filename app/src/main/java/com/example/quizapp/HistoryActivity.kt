package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
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

    private fun setRecycleView(list: ArrayList<Player>, playerDao: PlayerDao){
        if (list.isNotEmpty()){
            val historyAdapter = HistoryAdapter(
                items = list
            )
            binding.rvHistory.layoutManager = LinearLayoutManager(this)
            binding.rvHistory.adapter = historyAdapter
        }
    }
}