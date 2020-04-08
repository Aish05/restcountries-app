package aish.android.countries

import aish.android.countries.viewmodel.CountriesViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val countriesViewModel by viewModel<CountriesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countriesViewModel.getAllCountries()
        countriesViewModel.countriesList.observe(this, Observer {
            Log.d("@@countries", it.size.toString())
        })

        countriesViewModel.showError.observe(this, Observer {
            Log.d("@@error", it)
        })

        addCountriesFragment()
    }

    private fun addCountriesFragment() {

    }
}
