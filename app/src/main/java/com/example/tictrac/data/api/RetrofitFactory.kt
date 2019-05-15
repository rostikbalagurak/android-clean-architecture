package com.example.tictrac.data.api

import com.example.tictrac.BuildConfig
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitFactory {

    private const val CONNECT_TIMEOUT = 15
    private const val READ_WRITE_TIMEOUT = 30

    fun createApiRetrofit(
        gson: Gson,
        baseEndpoint: String
    ): Retrofit {
        val okHttpClient = okHttpClient(loggingInterceptor())
        val converterFactory = converterFactory(gson)
        val apiCallAdapter = RxJava2CallAdapterFactory.createAsync()

        return Retrofit.Builder()
            .baseUrl(baseEndpoint)
            .client(okHttpClient)
            .addCallAdapterFactory(apiCallAdapter)
            .addConverterFactory(converterFactory)
            .build()
    }

    private fun okHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(READ_WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(loggingInterceptor)
        }

        return builder.build()
    }

    private fun loggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return interceptor
    }

    private fun converterFactory(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }
}