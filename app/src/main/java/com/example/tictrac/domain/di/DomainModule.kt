package com.example.tictrac.domain.di

import com.example.tictrac.domain.boundaries.api.UsersAPI
import com.example.tictrac.domain.boundaries.repository.UserRepository
import com.example.tictrac.domain.usecase.UsersInteractor
import com.example.tictrac.domain.usecase.impl.DefaultUsersInteractor
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun usersInteractory(userRepository: UserRepository, usersAPI: UsersAPI): UsersInteractor {
        return DefaultUsersInteractor(userRepository, usersAPI)
    }
}