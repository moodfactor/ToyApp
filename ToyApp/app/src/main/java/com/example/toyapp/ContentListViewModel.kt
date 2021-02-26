package com.example.toyapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContentListViewModel : ViewModel() {

    var toyList = listOf<Toy>(
        Toy("Sheep", "cotton toy", R.drawable.ic_baseline_emoji_emotions_24),
        Toy("cowboy", "toy", R.drawable.ic_launcher_foreground)
    )


}