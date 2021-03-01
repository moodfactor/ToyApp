package com.mood.field.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mood.field.databinding.ListItemBinding
import com.mood.field.domain.Market

class MarketAdapter() : ListAdapter<Market, MarketAdapter.ViewHolder>(MarketDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item: Market){
            binding.market = item
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent:ViewGroup): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }

    class MarketDiffCallback: DiffUtil.ItemCallback<Market>(){
        override fun areItemsTheSame(oldItem: Market, newItem: Market): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Market, newItem: Market): Boolean {
            return oldItem == newItem
        }

    }
}