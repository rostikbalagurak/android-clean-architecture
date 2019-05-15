package com.example.tictrac.presentation.app

import android.app.Application
import com.example.tictrac.presentation.util.Connectivity
import com.example.tictrac.presentation.util.DefaultConnectivity
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    fun application(): Application {
        return application
    }

    @Provides
    fun connectivity(): Connectivity {
        return DefaultConnectivity()
    }
}