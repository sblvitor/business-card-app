package com.lira.businesscard.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.lira.businesscard.App
import com.lira.businesscard.R
import com.lira.businesscard.databinding.ActivityAddBusinessCardBinding
import com.lira.businesscard.model.local.BusinessCard
import com.lira.businesscard.viewmodel.MainViewModel
import com.lira.businesscard.viewmodel.MainViewModelFactory

class AddBusinessCardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBusinessCardBinding

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

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

        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                name = binding.etName.text.toString(),
                mobile = binding.etMobile.text.toString(),
                email = binding.etEmail.text.toString(),
                company = binding.etCompany.text.toString(),
                color = binding.etColor.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.txt_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}