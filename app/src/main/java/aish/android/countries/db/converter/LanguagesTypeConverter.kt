package aish.android.countries.db.converter

import aish.android.countries.db.model.Languages
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson


class LanguagesTypeConverter {
    @TypeConverter
    fun stringToLanguages(json: String): Languages {
        val gson = Gson()
        val type = object : TypeToken<Languages>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun languagesToString(list: Languages): String {
        val gson = Gson()
        val type = object : TypeToken<Languages>() {}.type
        return gson.toJson(list, type)
    }
}
