package com.mood.field.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mood.field.databinding.ListItemBinding
import com.mood.field.domain.Market

class MarketAdapter(val callback: MarketClick) : ListAdapter<Market, MarketAdapter.ViewHolder>(MarketDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item,callback)


    }

    class ViewHolder private constructor(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item: Market, callback: MarketClick){
            binding.market = item
            binding.marketCallback = callback
//            binding.executePendingBindings()
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
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Market, newItem: Market): Boolean {
            return oldItem == newItem
        }

    }

    /**
     * Click listener for Videos. By giving the block a name it helps a reader understand what it does.
     *
     */
    class MarketClick(val block: (Market) -> Unit) {
        /**
         * Called when a market item is clicked
         *
         * @param video the video that was clicked
         */
        fun onClick(marketItem: Market) = block(marketItem)
    }
}