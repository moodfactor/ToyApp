package com.example.toyapp

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toyapp.R.drawable.ic_baseline_emoji_emotions_24
import com.example.toyapp.database.Toy
import com.example.toyapp.database.ToyDatabaseDao
import kotlinx.coroutines.launch

class ToyDetailViewModel(val database:ToyDatabaseDao): ViewModel() {

    //ToDo update it to get it from database
     var toy = MutableLiveData<Toy?>()


    private fun initializeToy(){
        viewModelScope.launch {
            toy.value = getToy()
        }

    }

    private suspend fun getToy(): Toy?{
        return database.getRecentToy()
    }


}