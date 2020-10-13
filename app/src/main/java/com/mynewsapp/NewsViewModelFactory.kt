package com.mynewsapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mynewsapp.ui.NewsViewModel

@Suppress("UNCHECKED_CAST")
class NewsViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel() as T
    }
}
