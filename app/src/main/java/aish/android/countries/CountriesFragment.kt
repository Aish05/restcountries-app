package aish.android.countries

import aish.android.countries.viewmodel.CountriesViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import org.koin.android.viewmodel.ext.android.viewModel

class CountriesFragment : Fragment() {

    private val countriesViewModel by viewModel<CountriesViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        countriesViewModel.getAllCountries()
        countriesViewModel.countriesList.observe(viewLifecycleOwner, Observer {
            Log.d("@@countries", it.size.toString())
        })

        countriesViewModel.showError.observe(viewLifecycleOwner, Observer {
            Log.d("@@error", it)
        })
    }
}
