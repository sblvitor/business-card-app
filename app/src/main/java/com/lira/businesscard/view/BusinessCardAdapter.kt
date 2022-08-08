package com.lira.businesscard.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lira.businesscard.databinding.CardItemBinding
import com.lira.businesscard.model.local.BusinessCard

class BusinessCardAdapter(private val items: List<BusinessCard>): RecyclerView.Adapter<BusinessCardAdapter.ViewHolder>() {

    class ViewHolder(binding: CardItemBinding): RecyclerView.ViewHolder(binding.root){
        val tvName = binding.tvName
        val tvMobile = binding.tvMobile
        val tvEmail = binding.tvEmail
        val tvCompanyName = binding.tvCompanyName
        val cvMain = binding.cvMain
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.tvName.text = item.name
        holder.tvMobile.text = item.mobile
        holder.tvEmail.text = item.email
        holder.tvCompanyName.text = item.company

        holder.cvMain.setCardBackgroundColor(Color.parseColor(item.color))

        holder.itemView.setOnClickListener {

        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}