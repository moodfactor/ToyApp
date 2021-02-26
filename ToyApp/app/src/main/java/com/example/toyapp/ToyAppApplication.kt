package com.example.toyapp

import android.app.Application
import timber.log.Timber

class ToyAppApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}