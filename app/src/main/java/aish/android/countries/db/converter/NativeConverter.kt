package aish.android.countries.db.converter

import aish.android.countries.db.model.Native
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson


class NativeConverter {
    @TypeConverter
    fun stringToNative(json: String): Native? {
        val gson = Gson()
        val type = object : TypeToken<Native>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun nativeToString(name: Native): String {
        val gson = Gson()
        val type = object : TypeToken<Native>() {}.type
        return gson.toJson(name, type)
    }
}
