package com.example.tictrac.data.di

import com.example.tictrac.data.api.RetrofitFactory
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiClientSetupModule(private val baseUrl: String) {

    @Provides
    @Singleton
    fun retrofit(gson: Gson): Retrofit {
        return RetrofitFactory.createApiRetrofit(gson, baseUrl)
    }

    @Provides
    @Singleton
    fun gson(): Gson {
        return GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }
}