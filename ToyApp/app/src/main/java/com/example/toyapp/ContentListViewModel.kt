package com.example.toyapp

import android.app.Application
import androidx.lifecycle.*
import com.example.toyapp.database.Toy
import com.example.toyapp.database.ToyDatabaseDao
import kotlinx.coroutines.launch

class ContentListViewModel(val database: ToyDatabaseDao, application: Application) : ViewModel() {

    private var _navigateToToyDetail = MutableLiveData<Int>()
    val navigateToToyDetail
    get() = _navigateToToyDetail

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


    fun onToyItemClicked(id: Int){
        _navigateToToyDetail.value = id
    }

    fun onToyItemNavigated(){
        _navigateToToyDetail.value = null
    }


}