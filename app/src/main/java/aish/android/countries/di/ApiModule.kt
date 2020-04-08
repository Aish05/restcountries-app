package aish.android.countries.di

import aish.android.countries.CountriesApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun provideCountriesApi(retrofit: Retrofit): CountriesApi {
        return retrofit.create(CountriesApi::class.java)
    }
    single { provideCountriesApi(get()) }

}