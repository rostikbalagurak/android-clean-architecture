package com.example.tictrac.presentation.app.di

import com.example.tictrac.presentation.app.TicTracApp
import com.example.tictrac.presentation.users.di.UsersModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class,
        UsersModule::class
    ]
)
interface ApplicationComponent {

    fun inject(ticTracApp: TicTracApp)
}