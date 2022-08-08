package com.lira.businesscard.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lira.businesscard.R
import com.lira.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}