package aish.android.countries.views

import aish.android.countries.R
import aish.android.countries.util.replaceFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

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
        replaceFragment(CountriesFragment(),
            R.id.fragment_container
        )
    }

}
