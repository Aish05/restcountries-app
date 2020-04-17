package aish.android.countries.db

import aish.android.countries.db.model.CountriesData
import android.util.Log
import io.realm.Realm
import io.realm.RealmObject


class CountriesDaoImpl : CountriesDao {

    override fun add(countries: List<CountriesData>): Boolean {
        return try {
            val realm = Realm.getDefaultInstance()
            countries.forEach {
                it.id = (setUniqueId())
                it.name?.id = (setUniqueId())
                it.languages?.id = (setUniqueId())
            }
            realm.executeTransaction{realm1 ->
                realm1.insertOrUpdate(countries)
            }
            realm.close()
            true
        } catch (e: Exception) {
            println(e)
            Log.d("Adding Exception", e.message)
            false
        }
    }

    override fun findAll(): List<CountriesData> {
        val realm = Realm.getDefaultInstance()
        val list =  realm.copyFromRealm(realm.where(CountriesData::class.java).findAll())
        realm.close()
        return list
    }



    fun clearAll() {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction { realm1: Realm ->
            realm1.delete(CountriesData::class.java)
        }
        realm.close()
    }

    var num = 0
    fun setUniqueId(): Int {
        num += 1
        return num
    }
}
