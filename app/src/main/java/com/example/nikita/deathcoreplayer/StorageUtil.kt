package com.example.nikita.deathcoreplayer

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class StorageUtil(private val context: Context) {

    private val storage = "com.example.nikita.deathcoreplayer.STORAGE"
    private var preferences: SharedPreferences? = null

    fun storeAudio(arrayList: ArrayList<Audio>) {
        preferences = context.getSharedPreferences(storage, Context.MODE_PRIVATE)

        val editor = preferences!!.edit()
        val gson = Gson()
        val json = gson.toJson(arrayList)
        editor.putString("audioArrayList", json)
        editor.apply()
    }

    fun loadAudio(): ArrayList<Audio>? {
        preferences = context.getSharedPreferences(storage, Context.MODE_PRIVATE)
        val gson = Gson()
        val json = preferences!!.getString("audioArrayList", null)
        val type = object : TypeToken<ArrayList<Audio>>() {

        }.type
        return gson.fromJson<ArrayList<Audio>>(json, type)
    }

    fun storeAudioIndex(index: Int) {
        preferences = context.getSharedPreferences(storage, Context.MODE_PRIVATE)
        val editor = preferences!!.edit()
        editor.putInt("audioIndex", index)
        editor.apply()
    }

    fun loadAudioIndex(): Int {
        preferences = context.getSharedPreferences(storage, Context.MODE_PRIVATE)
        return preferences!!.getInt("audioIndex", -1)
    }

    fun clearCachedAudioPlaylist() {
        preferences = context.getSharedPreferences(storage, Context.MODE_PRIVATE)
        val editor = preferences!!.edit()
        editor.clear()
        editor.apply()
    }
}
