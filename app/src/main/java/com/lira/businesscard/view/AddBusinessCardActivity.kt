package com.lira.businesscard.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lira.businesscard.R
import com.lira.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBusinessCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBusinessCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener(){
        binding.ibCancel.setOnClickListener {
            finish()
        }
    }
}