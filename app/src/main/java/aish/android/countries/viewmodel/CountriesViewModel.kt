package aish.android.countries.viewmodel

import aish.android.countries.db.model.CountriesData
import aish.android.countries.repository.CountriesRepository
import aish.android.countries.util.AppResult
import aish.android.countries.util.SingleLiveEvent
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CountriesViewModel(private val repository : CountriesRepository) : ViewModel() {

    val showLoading = ObservableBoolean()
    val countriesList = MutableLiveData<List<CountriesData>>()
    val showError = SingleLiveEvent<String>()

    fun getAllCountries() {
        showLoading.set(true)
        viewModelScope.launch {
            val result =  repository.getAllCountries()

            showLoading.set(false)
            when (result) {
                is AppResult.Success -> {
                    countriesList.value = result.successData
                    showError.value = null
                }
                is AppResult.Error -> showError.value = result.exception.message
            }
        }
    }
}