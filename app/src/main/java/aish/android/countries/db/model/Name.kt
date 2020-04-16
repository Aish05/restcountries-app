package aish.android.countries.db.model

import android.os.Parcelable

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import kotlinx.android.parcel.Parcelize

open class Name(
    var common: String? = "",
    var official: String? = "",
    var native: Native? = null
) :  RealmObject() {
    @PrimaryKey
    var id: Int = 0

}