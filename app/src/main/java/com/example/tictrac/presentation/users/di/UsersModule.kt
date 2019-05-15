package com.example.tictrac.presentation.users.di

import com.example.tictrac.presentation.users.UsersActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UsersModule {

    @ContributesAndroidInjector
    abstract fun contributeUserActivity(): UsersActivity
}