package aish.android.countries.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Translations")
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
)