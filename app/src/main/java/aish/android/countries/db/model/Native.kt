package aish.android.countries.db.model

import android.os.Parcelable
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

import kotlinx.android.parcel.Parcelize


open class Native(@PrimaryKey var id: Int? = 0,
                  var common: String? = "",
                  var official: String? = "") :  RealmObject()