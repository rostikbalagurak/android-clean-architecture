package com.example.tictrac.data.di

import com.example.tictrac.data.database.di.RepositoryModule
import dagger.Module

@Module(
    includes = [
        ApiCallsModule::class,
        APIClientModule::class,
        ApiClientSetupModule::class,
        RepositoryModule::class
    ]
)
class DataModule