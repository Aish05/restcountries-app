package aish.android.countries.db.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Translations")
@Parcelize
data class Translations(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val cym: String?,
    val deu: String?,
    val fra: String?,
    val hrv: String?,
    val ita: String?,
    val jpn: String?,
    val nld: String?,
    val por: String?,
    val rus: String?,
    val spa: String?
) : Parcelable