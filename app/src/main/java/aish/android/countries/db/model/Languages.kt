package aish.android.countries.db.model

import android.os.Parcelable
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import kotlinx.android.parcel.Parcelize


open class Languages(
    @PrimaryKey var id: Int? = 0,
    var bwg: String? = null,
    var eng: String? = null,
    var kck: String? = null,
    var khi: String? = null,
    var ndc: String? = null,
    var nde: String? = null,
    var nya: String? = null,
    var sna: String? = null,
    var sot: String? = null,
    var toi: String? = null,
    var tsn: String? = null,
    var tso: String? = null,
    var ven: String? = null,
    var xho: String? = null,
    var zib: String? = null
) : RealmObject()