package aish.android.countries.core

import aish.android.countries.di.*
import android.R.attr.key
import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class CountiesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initRealm()
        startKoin {
            androidLogger()
            androidContext(this@CountiesApplication)
            modules(
                apiModule,
                viewModelModule,
                repositoryModule,
                networkModule,
                databaseModule
            )
        }
    }

    private fun initRealm() {
        Realm.init(this@CountiesApplication)
        val config = RealmConfiguration.Builder()
            .name("countries")
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config);
    }
}