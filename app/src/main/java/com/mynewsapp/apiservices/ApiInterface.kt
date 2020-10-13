package com.mynewsapp.apiservices

import com.mynewsapp.model.NewsModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

interface ApiInterface {
    @GET("top-headlines")
    fun fetchLatestNewsData(@Query("country") query: String?) : Observable<NewsModel>
}
