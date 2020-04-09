package aish.android.countries

import aish.android.countries.util.replaceFragment
import aish.android.countries.viewmodel.CountriesViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar()
        addCountriesFragment()
    }

    private fun setToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar?.title = "All Countries"
    }

    private fun addCountriesFragment() {
        /* Display First Fragment initially */
        replaceFragment(CountriesFragment(), R.id.fragment_container)
    }

}
