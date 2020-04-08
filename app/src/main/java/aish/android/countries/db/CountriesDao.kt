package aish.android.countries.db

import aish.android.countries.db.model.CountriesData
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountriesDao {

    @Query("SELECT * FROM Countries")
    fun findAll(): LiveData<List<CountriesData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(users: List<CountriesData>)
}