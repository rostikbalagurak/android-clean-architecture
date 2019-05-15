package com.example.tictrac.presentation.app.di

import com.example.tictrac.data.di.DataModule
import com.example.tictrac.domain.di.DomainModule
import com.example.tictrac.presentation.app.ApplicationModule
import com.example.tictrac.presentation.app.di.viewmodel.ViewModelModule
import dagger.Module

@Module(
    includes = [
        ApplicationModule::class,
        DataModule::class,
        DomainModule::class,
        ViewModelModule::class
    ]
)
class AppModule