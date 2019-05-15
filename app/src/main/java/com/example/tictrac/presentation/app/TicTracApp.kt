package com.example.tictrac.presentation.app

import android.app.Activity
import android.app.Application
import com.example.tictrac.BuildConfig
import com.example.tictrac.data.di.ApiClientSetupModule
import com.example.tictrac.domain.di.DomainModule
import com.example.tictrac.presentation.app.di.ApplicationComponent
import com.example.tictrac.presentation.app.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class TicTracApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initRealm()
        initDaggerComponent()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    private fun initRealm() {
//        Realm.init(this)
//
//        val config = RealmConfiguration.Builder()
//            .deleteRealmIfMigrationNeeded()
//            .build()
//        Realm.setDefaultConfiguration(config)
    }

    private fun initDaggerComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .apiClientSetupModule(ApiClientSetupModule(BuildConfig.SERVER_URL))
            .domainModule(DomainModule())
            .build()
        applicationComponent.inject(this)
    }
}