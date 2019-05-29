package com.strikalov.mdhomeworkproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    public static Intent newIntent(Context context){
        return new Intent(context, SettingsActivity.class);
    }

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        int theme = sp.getInt(Constants.THEME, R.style.AppTheme);
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button1 = findViewById(R.id.button_theme1);
        button2 = findViewById(R.id.button_theme2);
        button3 = findViewById(R.id.button_theme3);
        button4 = findViewById(R.id.button_theme4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().putInt(Constants.THEME, R.style.AppTheme).apply();
                setResult(RESULT_OK);
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().putInt(Constants.THEME, R.style.AppTheme2).apply();
                setResult(RESULT_OK);
                finish();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().putInt(Constants.THEME, R.style.AppTheme3).apply();
                setResult(RESULT_OK);
                finish();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().putInt(Constants.THEME, R.style.AppTheme4).apply();
                setResult(RESULT_OK);
                finish();
            }
        });


    }
}


