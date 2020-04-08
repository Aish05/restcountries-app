package aish.android.countries.repository

import aish.android.countries.CountriesApi
import aish.android.countries.db.model.CountriesData
import aish.android.countries.util.AppResult
import aish.android.countries.util.NetworkManager.isOnline
import aish.android.countries.util.Utils.handleApiError
import aish.android.countries.util.Utils.handleSuccess
import aish.android.countries.util.noNetworkConnectivityError
import android.content.Context

class CountriesRepositoryImpl(private val api: CountriesApi, private val context: Context) :
    CountriesRepository {

    override suspend fun getAllCountries(): AppResult<List<CountriesData>> {
        if (isOnline(context)) {
            return try {
                val response = api.getAllCountries()
                if (response.isSuccessful) {
                    handleSuccess(response)
                } else {
                    handleApiError(response)
                }
            } catch (e: Exception) {
                AppResult.Error(e)
            }
        } else {
            //no network
            return context.noNetworkConnectivityError()
        }
    }


}