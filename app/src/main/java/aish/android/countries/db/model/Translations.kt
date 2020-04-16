package aish.android.countries.db.model

import android.os.Parcelable
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import kotlinx.android.parcel.Parcelize


open class Translations(
    @PrimaryKey var id: Int? = 0,
    var cym: String? = null,
    var deu: String? = null,
    var fra: String? = null,
    var hrv: String? = null,
    var ita: String? = null,
    var jpn: String? = null,
    var nld: String? = null,
    var por: String? = null,
    var rus: String? = null,
    var spa: String? = null
) :  RealmObject()