package aish.android.countries

import aish.android.countries.di.*
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CountiesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
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
}