package aish.android.countries.repository

import aish.android.countries.db.model.CountriesData
import aish.android.countries.util.AppResult
import androidx.lifecycle.LiveData

interface CountriesRepository {
    suspend fun getAllCountries() : AppResult<List<CountriesData>>
    fun clear()
}
