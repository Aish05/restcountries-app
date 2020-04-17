package aish.android.countries.repository

import aish.android.countries.CountriesApi
import aish.android.countries.db.CountriesDao
import aish.android.countries.db.model.CountriesData
import aish.android.countries.util.AppResult
import aish.android.countries.util.NetworkManager.isOnline
import aish.android.countries.util.TAG
import aish.android.countries.util.Utils.handleApiError
import aish.android.countries.util.Utils.handleSuccess
import aish.android.countries.util.noNetworkConnectivityError
import android.content.Context
import android.util.Log
import io.realm.RealmObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CountriesRepositoryImpl(
    private val api: CountriesApi,
    private val context: Context,
    private val dao: CountriesDao
) :
    CountriesRepository {

    override suspend fun getAllCountries(): AppResult<List<CountriesData>> {
        if (isOnline(context)) {
            return try {
                val response = api.getAllCountries()
                if (response.isSuccessful) {
                    //save the data
                    response.body()?.let {
                        withContext(Dispatchers.IO) {
                            val isAdded = dao.add(it)
                            Log.d("isAdded", isAdded.toString())
                        }
                    }
                    handleSuccess(response)
                } else {
                    handleApiError(response)
                }
            } catch (e: Exception) {
                AppResult.Error(e)
            }
        } else {
            //check in db if the data exists
            val data = getCountriesDataFromCache()
            return if (data.isNotEmpty()) {
                Log.d(TAG, "from db")
                AppResult.Success(data)
            } else
            //no network
                context.noNetworkConnectivityError()
        }
    }

    private suspend fun getCountriesDataFromCache(): List<CountriesData> {
        return withContext(Dispatchers.IO) {
            dao.findAll()
        }
    }



}