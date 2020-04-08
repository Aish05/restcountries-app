package aish.android.countries.viewmodel

import aish.android.countries.db.model.CountriesData
import aish.android.countries.repository.CountriesRepository
import aish.android.countries.util.AppResult
import aish.android.countries.util.SingleLiveEvent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CountriesViewModel(private val repository : CountriesRepository) : ViewModel() {

    val showLoading = MutableLiveData<Boolean>()
    val countriesList = MutableLiveData<List<CountriesData>>()
    val showError = SingleLiveEvent<String>()

    fun getAllCountries() {
        viewModelScope.launch {
            val result = repository.getAllCountries()
            // Hide progressBar once the operation is done on the MAIN (default) thread
            showLoading.value = false
            when (result) {
                is AppResult.Success -> countriesList.value = result.successData
                is AppResult.Error -> showError.value = result.exception.message
            }
        }
    }
}