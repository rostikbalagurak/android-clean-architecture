package com.example.tictrac.data.di

import com.example.tictrac.data.api.client.UsersClient
import com.example.tictrac.data.api.impl.DefaultUsersAPI
import com.example.tictrac.domain.boundaries.api.UsersAPI
import dagger.Module
import dagger.Provides

@Module
class ApiCallsModule {

    @Provides
    fun usersAPI(apiClient: UsersClient): UsersAPI {
        return DefaultUsersAPI(apiClient)
    }
}