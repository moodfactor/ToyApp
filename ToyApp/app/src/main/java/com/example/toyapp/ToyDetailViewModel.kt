package com.example.toyapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.toyapp.R.drawable.ic_baseline_emoji_emotions_24

class ToyDetailViewModel: ViewModel() {

    val toy = Toy("Horse", "platic toy", image = ic_baseline_emoji_emotions_24)




}