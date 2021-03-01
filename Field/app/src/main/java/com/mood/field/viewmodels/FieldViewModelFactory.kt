package com.mood.field.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


/**
 * Factory for costructing FieldViewModel with parameter
 */
class FieldViewModelFactory(val app : Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FieldViewModel::class.java)){
            return FieldViewModel(app) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}