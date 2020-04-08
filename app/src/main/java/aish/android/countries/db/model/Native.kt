package aish.android.countries.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Native")
data class Native(@PrimaryKey(autoGenerate = true) val id: Int,
                  val common: String? = "",
                  val official: String? = "")