package com.example.toyapp

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.toyapp.database.Toy

@BindingAdapter("setTitle")
fun TextView.setTitle(item: Toy?){
    item?.let {
        text = item.title.capitalize()
    }
}

@BindingAdapter("setDescription")
fun TextView.setDescription(item: Toy?){
    item?.let {
        text = item.description.capitalize()
    }
}

@BindingAdapter("toyImage")
fun ImageView.setImage(item: Toy?){
    item?.image.apply {
        setImageResource(R.drawable.ic_baseline_emoji_emotions_24)
    }
}