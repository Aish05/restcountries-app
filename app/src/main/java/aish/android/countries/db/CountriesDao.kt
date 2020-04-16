package aish.android.countries.db

import aish.android.countries.db.model.CountriesData
import androidx.lifecycle.LiveData
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmResults


interface CountriesDao {

    fun add(countries: RealmList<CountriesData>): Boolean
    fun findAll(): List<CountriesData>

    fun closeInstance()

    /*fun delStudent(realm: Realm, _ID: Int): Boolean
    fun editStudent(realm: Realm, student: Student): Boolean
    fun getStudent(realm: Realm, studentId: Int): Student
    fun removeLastStudent(realm: Realm)*/

}