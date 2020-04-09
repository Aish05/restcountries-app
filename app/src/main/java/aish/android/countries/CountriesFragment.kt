package aish.android.countries

import aish.android.countries.databinding.FragmentCountriesBinding
import aish.android.countries.viewmodel.CountriesViewModel
import aish.android.countries.views.CountriesAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_countries.*
import org.koin.android.viewmodel.ext.android.viewModel

class CountriesFragment : Fragment() {

    private val countriesViewModel by viewModel<CountriesViewModel>()
    private lateinit var countriesAdapter: CountriesAdapter
    private lateinit var mViewDataBinding: FragmentCountriesBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewDataBinding  = DataBindingUtil.inflate(inflater, R.layout.fragment_countries, container, false)
        val mRootView = mViewDataBinding.root
        mViewDataBinding.lifecycleOwner = this
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setView()

        mViewDataBinding.viewModel = countriesViewModel
        countriesViewModel.getAllCountries()
        countriesViewModel.countriesList.observe(viewLifecycleOwner, Observer {
            Log.d("@@countries", it.size.toString())
            if (it.isNotEmpty() && it != null) {
                countriesAdapter.setCountries(it)
            }
        })

//        countriesViewModel.showError.observe(viewLifecycleOwner, Observer {
//            Log.d("@@error", it)
//        })
    }

    private fun setView() {
        countriesAdapter = CountriesAdapter(context)
        rv_countries.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rv_countries.adapter = countriesAdapter
        rv_countries.isNestedScrollingEnabled = false
    }
}
