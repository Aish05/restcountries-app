package aish.android.countries.db

import aish.android.countries.db.converter.*
import aish.android.countries.db.model.*
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [CountriesData::class, Languages::class, Name::class, Native::class, Translations::class],
    version = 1, exportSchema = false
)

@TypeConverters(
    Converters::class,
    LanguagesTypeConverter::class,
    NameConverter::class,
    NativeConverter::class,
    TranslationsConverter::class)
abstract class CountriesDatabase : RoomDatabase() {
    abstract val countriesDao: CountriesDao
}