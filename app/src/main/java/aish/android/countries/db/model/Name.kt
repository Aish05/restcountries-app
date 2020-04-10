package aish.android.countries.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Name")
@Parcelize
data class Name(
    var common: String? = "",
    var official: String? = "",
    var native: Native? = null
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}