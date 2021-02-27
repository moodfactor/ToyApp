package com.example.toyapp

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.toyapp.database.ToyDatabaseDao

class ContentListViewModelFactory(
    private val dataSource: ToyDatabaseDao,
    private val application: Application
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContentListViewModel::class.java)) {

            return ContentListViewModel(dataSource, application as ToyAppApplication) as T
        }

        throw IllegalArgumentException("Unkown ViewModel Class")
    }
}