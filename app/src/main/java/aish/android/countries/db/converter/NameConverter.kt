package aish.android.countries.db.converter

import aish.android.countries.db.model.Name
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson


class NameConverter {
    @TypeConverter
    fun stringToName(json: String): Name? {
        val gson = Gson()
        val type = object : TypeToken<Name>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun nameToString(name: Name): String {
        val gson = Gson()
        val type = object : TypeToken<Name>() {}.type
        return gson.toJson(name, type)
    }
}
