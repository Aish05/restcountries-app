package aish.android.countries.di

import aish.android.countries.db.CountriesDao
import aish.android.countries.db.CountriesDaoImpl
import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val databaseModule = module {

    fun provideCountriesDao(): CountriesDao {
        return CountriesDaoImpl()
    }

    factory { provideCountriesDao() }

}

