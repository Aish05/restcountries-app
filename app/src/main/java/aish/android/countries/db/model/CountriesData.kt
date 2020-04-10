package aish.android.countries.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Countries")
@Parcelize
class CountriesData (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: Name?,
    val tld: List<String>?,
    val cca2: String?,
    val ccn3: String?,
    val cca3: String?,
    val currency: List<String>?,
    val callingCode: List<String>?,
    val capital: String?,
    val altSpellings: List<String>?,
    val relevance: String?,
    val region: String?,
    val subregion: String?,
    val nativeLanguage: String?,
    val languages: Languages?,
    val translations: Translations?,
    val demonym: String?,
    val borders: List<String>?,
    val area: Double?
) : Parcelable

