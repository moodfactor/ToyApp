package com.example.toyapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.toyapp.ToyAppAdapter.ViewHolder
import com.example.toyapp.database.Toy
import com.example.toyapp.databinding.PlayItemBinding

class ToyAppAdapter(val clickListener: ToyListener) : androidx.recyclerview.widget.ListAdapter<Toy, ViewHolder>(ToyDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder.from(parent)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    class ViewHolder(val binding: PlayItemBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(
            item: Toy,
            clickListener: ToyListener
        ) {
            binding.toy = item
            binding.clickListener = clickListener
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

    class ToyListener(val clickListener: (toyId: Int) -> Unit){

        fun onClick(toy: Toy)= clickListener(toy.toyId)
    }


}