package aish.android.countries.db

import aish.android.countries.db.model.CountriesData
import android.util.Log
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmResults

class CountriesDaoImpl(var realm: Realm) : CountriesDao {

    override fun add(countries: RealmList<CountriesData>): Boolean {
        return try {
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(countries)
            realm.commitTransaction()
            true
        } catch (e: Exception) {
            Log.d("Adding Exception", e.message)
            false
        }
    }

    override fun findAll(): List<CountriesData> {
        return realm.where(CountriesData::class.java).findAll()
       // realm.copyFromRealm(realm.where(CountriesData::class.java).findAll())
    }

    override fun closeInstance() {
        realm.close()
    }

    fun clearAll() {
        realm.executeTransaction { realm1: Realm ->
            realm1.delete(CountriesData::class.java)
        }
    }
}
