package aish.android.countries.di

import aish.android.countries.viewmodel.CountriesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    // Specific viewModel pattern to tell Koin how to build CountriesViewModel
    viewModel {
        CountriesViewModel(repository = get())
    }

}