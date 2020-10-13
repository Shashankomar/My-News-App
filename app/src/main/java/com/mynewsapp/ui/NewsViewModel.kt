package com.mynewsapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mynewsapp.apiservices.ApiInterface
import com.mynewsapp.injection.BaseViewModel
import com.mynewsapp.model.NewsModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsViewModel : BaseViewModel() {
//    val successMsg: MutableLiveData<NewsModel> = MutableLiveData()

    private val newsData: MutableLiveData<NewsModel> = MutableLiveData()
    var subscribe: Disposable? = null

    @Inject
    lateinit var apiInterface: ApiInterface

    init {
        getNews()
    }

    private fun getNews() {
        subscribe = apiInterface.fetchLatestNewsData("in")
            .subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                { response -> onRetrieveNewsListSuccess(response) },
                { t -> onRetrieveNewsListError(t) }
            )
    }

    private fun onRetrieveNewsListSuccess(response: NewsModel) {
//        successMsg.value = "yo success!!!!!"
       newsData.postValue(response)
        Log.d("----", "response is there!")
    }

    private fun onRetrieveNewsListError(t: Throwable) {
        Log.d("----", "error ${t.message}")
    }

    override fun onCleared() {
        super.onCleared()
        subscribe?.dispose()
    }
}