package com.mynewsapp.apiservices

import com.mynewsapp.utils.Constants.API_KEY
import com.mynewsapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@Suppress("unused")
object NetworkModule {
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideHttpClient(): OkHttpClient {

        val interceptor = Interceptor { chain ->
            val url = chain.request().url.newBuilder().addQueryParameter(
                "apiKey",
                API_KEY
            ).build()
            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()
            chain.proceed(request)
        }
        return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}