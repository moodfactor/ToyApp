package com.example.toyapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.toyapp.ToyAppAdapter.ViewHolder
import com.example.toyapp.databinding.PlayItemBinding

class ToyAppAdapter : androidx.recyclerview.widget.ListAdapter<Toy, ViewHolder>(ToyDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder.from(parent)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder(val binding: PlayItemBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: Toy) {
            binding.toy = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)

                val binding = PlayItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }

    class ToyDiffCallback : DiffUtil.ItemCallback<Toy>() {
        override fun areItemsTheSame(oldItem: Toy, newItem: Toy): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Toy, newItem: Toy): Boolean {
            return oldItem == newItem
        }

    }


}