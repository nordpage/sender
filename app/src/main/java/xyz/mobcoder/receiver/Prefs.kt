package xyz.mobcoder.receiver

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    var sharedPreference: SharedPreferences? = null

    init {
        sharedPreference =  context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
    }

    fun saveTime(time: Long) {
        val editor = sharedPreference!!.edit()
        editor.putLong(TIME, time)
        editor.commit()
    }

    fun getTime() : Long {
        return sharedPreference!!.getLong(TIME,0L)
    }

    companion object {
        const val TIME = "time"
    }
}