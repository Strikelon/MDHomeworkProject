package com.strikalov.mdhomeworkproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainNavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private static final int REQUEST_CODE_SETTINGS = 1;

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        int theme = sp.getInt(Constants.THEME, R.style.AppTheme);
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Intent intent = null;
        boolean isNeedToStartForResult = false;

        int id = item.getItemId();

        switch (id){
            case R.id.nav_fruits:
                intent = ImageActivity.newIntent(this, "nav_fruits");
                break;
            case R.id.nav_vegetables:
                intent = ImageActivity.newIntent(this, "nav_vegetables");
                break;
            case R.id.nav_nature:
                intent = TabActivity.newIntent(this);
                break;
            case R.id.nav_settings:
                intent = SettingsActivity.newIntent(this);
                isNeedToStartForResult = true;
                break;
            default:
                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        if(intent != null){
            if(isNeedToStartForResult){
                startActivityForResult(intent, REQUEST_CODE_SETTINGS);
            }else {
                startActivity(intent);
            }
        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_SETTINGS && resultCode == RESULT_OK){
            recreate();
        }
    }
}
