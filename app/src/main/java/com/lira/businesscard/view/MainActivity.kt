package com.lira.businesscard.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lira.businesscard.App
import com.lira.businesscard.databinding.ActivityMainBinding
import com.lira.businesscard.viewmodel.MainViewModel
import com.lira.businesscard.viewmodel.MainViewModelFactory
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private var adapter: BusinessCardAdapter = BusinessCardAdapter(Collections.emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCards.layoutManager = LinearLayoutManager(this)
        binding.rvCards.adapter = adapter

        getAllBusinessCard()
        insertListener()
    }

    private fun insertListener(){
        binding.fabAddCard.setOnClickListener {
            val intent = Intent(this@MainActivity, AddBusinessCardActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getAllBusinessCard(){
        mainViewModel.getAll().observe(this, { businessCardList ->
            adapter = BusinessCardAdapter(businessCardList)
            binding.rvCards.adapter = adapter
        })
    }
}