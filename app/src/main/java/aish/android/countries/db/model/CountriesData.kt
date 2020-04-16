package aish.android.countries.db.model

import android.os.Parcelable
import io.realm.RealmList

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import kotlinx.android.parcel.Parcelize

open class CountriesData (
    @PrimaryKey
    var id: Int? = 0,
    var name: Name? = null,
    var tld: RealmList<String>? = null,
    var cca2: String? = null,
    var ccn3: String? = null,
    var cca3: String? = null,
    var currency: RealmList<String>? = null,
    var callingCode: RealmList<String>? = null,
    var capital: String? = null,
    var altSpellings: RealmList<String>? = null,
    var relevance: String? = null,
    var region: String? = null,
    var subregion: String? = null,
    var nativeLanguage: String? = null,
    var languages: Languages? = null,
    var translations: Translations? = null,
    var demonym: String? = null,
    var borders: RealmList<String>? = null,
    var area: Double? = null
) :  RealmObject()

