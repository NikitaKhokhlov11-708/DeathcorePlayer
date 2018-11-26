package com.example.nikita.deathcoreplayer

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class SettingsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnRed: Button
    private lateinit var btnGreen: Button
    private lateinit var btnPurple: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        btnRed = findViewById(R.id.btn_red)
        btnGreen = findViewById(R.id.btn_green)
        btnPurple = findViewById(R.id.btn_purple)
        btnRed.setOnClickListener(this)
        btnGreen.setOnClickListener(this)
        btnPurple.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        var theme = -5
        when (v.id) {
            R.id.btn_red -> theme = sp.getInt("THEME", R.style.RedTheme)
            R.id.btn_green -> theme = sp.getInt("THEME", R.style.GreenTheme)
            R.id.btn_purple -> theme = sp.getInt("THEME", R.style.PurpleTheme)
        }

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("THEME", theme)
        startActivity(intent)
    }
}
