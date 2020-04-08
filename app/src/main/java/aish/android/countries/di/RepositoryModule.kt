package aish.android.countries.di

import aish.android.countries.CountriesApi
import aish.android.countries.repository.CountriesRepository
import aish.android.countries.repository.CountriesRepositoryImpl
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    fun provideUserRepository(api: CountriesApi, context: Context): CountriesRepository {
        return CountriesRepositoryImpl(api, context)
    }
    single { provideUserRepository(get(), androidContext()) }

}