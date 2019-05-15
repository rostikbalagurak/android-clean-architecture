package com.example.tictrac.data.database.di

import com.example.tictrac.data.database.DefaultUsersRepository
import com.example.tictrac.domain.boundaries.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun usersRepository(): UserRepository {
        return DefaultUsersRepository()
    }
}