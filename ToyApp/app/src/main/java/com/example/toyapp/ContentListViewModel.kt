package com.example.toyapp

import android.app.Application
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toyapp.database.Toy
import com.example.toyapp.database.ToyDatabaseDao
import kotlinx.coroutines.launch

class ContentListViewModel(val database: ToyDatabaseDao, application: Application) : ViewModel() {

    //ToDo Update the list to get it from database
    var toyList = database.getAllToys()

    private var recentToy = MutableLiveData<Toy?>()





    init{
        viewModelScope.launch {
            recentToy.value = getRecentToyFromDatabase()
        }
    }

    private suspend fun getRecentToyFromDatabase(): Toy?{
        return database.getRecentToy()
    }



}