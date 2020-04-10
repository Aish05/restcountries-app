package aish.android.countries.di

import aish.android.countries.CountriesApi
import aish.android.countries.db.CountriesDao
import aish.android.countries.repository.CountriesRepository
import aish.android.countries.repository.CountriesRepositoryImpl
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    fun provideUserRepository(api: CountriesApi, context: Context, dao : CountriesDao): CountriesRepository {
        return CountriesRepositoryImpl(api, context, dao)
    }
    single { provideUserRepository(get(), androidContext(), get()) }

}