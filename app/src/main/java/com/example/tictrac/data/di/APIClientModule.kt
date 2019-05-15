package com.example.tictrac.data.di

import com.example.tictrac.data.api.client.UsersClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class APIClientModule {

    @Provides
    @Singleton
    fun usersClient(retrofit: Retrofit): UsersClient {
        return retrofit.create(UsersClient::class.java)
    }
}