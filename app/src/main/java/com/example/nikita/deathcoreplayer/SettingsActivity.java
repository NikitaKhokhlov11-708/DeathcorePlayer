package com.example.nikita.deathcoreplayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnRed;
    Button btnGreen;
    Button btnPurple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        btnRed = findViewById(R.id.btn_red);
        btnGreen = findViewById(R.id.btn_green);
        btnPurple = findViewById(R.id.btn_purple);
        btnRed.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnPurple.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        int theme = -5;
        switch (v.getId()) {
            case R.id.btn_red:
                theme = sp.getInt("THEME", R.style.RedTheme);
                break;
            case R.id.btn_green:
                theme = sp.getInt("THEME", R.style.GreenTheme);
                break;
            case R.id.btn_purple:
                theme = sp.getInt("THEME", R.style.PurpleTheme);
                break;
        }

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("THEME", theme);
        startActivity(intent);
    }
}
