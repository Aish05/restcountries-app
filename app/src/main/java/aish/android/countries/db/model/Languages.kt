package aish.android.countries.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Languages")
@Parcelize
data class Languages(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val bwg: String?,
    val eng: String?,
    val kck: String?,
    val khi: String?,
    val ndc: String?,
    val nde: String?,
    val nya: String?,
    val sna: String?,
    val sot: String?,
    val toi: String?,
    val tsn: String?,
    val tso: String?,
    val ven: String?,
    val xho: String?,
    val zib: String?
) : Parcelable