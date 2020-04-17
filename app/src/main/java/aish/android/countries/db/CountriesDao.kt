package aish.android.countries.db

import aish.android.countries.db.model.CountriesData
import androidx.lifecycle.LiveData
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmResults


interface CountriesDao {

    fun add(countries: List<CountriesData>): Boolean
    fun findAll(): List<CountriesData>
}