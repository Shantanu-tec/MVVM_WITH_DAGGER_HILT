package com.appsquadz.mvvmwithretrofit.onboarding

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class OnBoardingApplication : Application() {

    companion object{
        @get:Synchronized
        lateinit var initializer: OnBoardingApplication
        private set

    }

    override fun onCreate() {
        super.onCreate()
        initializer = this
    }

}