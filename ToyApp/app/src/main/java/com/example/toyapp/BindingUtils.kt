package com.example.toyapp

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("setTitle")
fun TextView.setTitle(item: Toy){
    text = item.title.capitalize()
}

@BindingAdapter("setDescription")
fun TextView.setDescription(item: Toy){
    text = item.description.capitalize()
}

@BindingAdapter("toyImage")
fun ImageView.setImage(item: Toy){
    item.image.apply {
        setImageResource(R.drawable.ic_baseline_emoji_emotions_24)
    }
}