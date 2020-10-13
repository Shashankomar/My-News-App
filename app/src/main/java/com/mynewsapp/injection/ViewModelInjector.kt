package com.mynewsapp.injection

import com.mynewsapp.ui.NewsViewModel
import com.mynewsapp.apiservices.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(newsViewModel: NewsViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}