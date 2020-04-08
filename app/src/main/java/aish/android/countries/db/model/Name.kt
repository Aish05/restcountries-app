package aish.android.countries.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Name")
data class Name(
    var common: String? = "",
    var official: String? = "",
    var native: Native? = null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}