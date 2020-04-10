package aish.android.countries.views

import aish.android.countries.db.model.CountriesData

interface CountryClickListener {
    fun onItemClick(country : CountriesData)
}