package com.mynewsapp.injection

import androidx.lifecycle.ViewModel
import com.mynewsapp.apiservices.NetworkModule
import com.mynewsapp.ui.NewsViewModel

abstract class BaseViewModel : ViewModel(){

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is NewsViewModel -> injector.inject(this)
        }
    }
}