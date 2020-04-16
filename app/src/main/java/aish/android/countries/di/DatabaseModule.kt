package aish.android.countries.di

import aish.android.countries.db.CountriesDao
import aish.android.countries.db.CountriesDaoImpl
import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val databaseModule = module {

    fun provideRealmDatabase(application: Application): Realm {
        Realm.init(application)
        val builder = RealmConfiguration.Builder()
        builder.name("countries")
        val config = builder.build()
        return Realm.getInstance(config)
    }


    fun provideCountriesDao(realm: Realm): CountriesDao {
        return CountriesDaoImpl(realm)
    }

    single { provideRealmDatabase(androidApplication()) }
    single { provideCountriesDao(get()) }

}

