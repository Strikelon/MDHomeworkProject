package com.strikalov.mdhomeworkproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class TabActivity extends AppCompatActivity {

    private static final int FIRST_NATURE = 1;
    private static final int SECOND_NATURE = 2;
    private static final int THIRD_NATURE = 3;

    private static final String FIRST_TAB = "Лес";
    private static final String SECOND_TAB = "Пустыня";
    private static final String THIRD_TAB = "Горы";

    public static Intent newIntent(Context context){
        return new Intent(context, TabActivity.class);
    }

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        Fragment imageFragment1 = ImageFragment.newInstance(FIRST_NATURE);
        Fragment imageFragment2 = ImageFragment.newInstance(SECOND_NATURE);
        Fragment imageFragment3 = ImageFragment.newInstance(THIRD_NATURE);

        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        myAdapter.addFragmet(imageFragment1, FIRST_TAB);
        myAdapter.addFragmet(imageFragment2, SECOND_TAB);
        myAdapter.addFragmet(imageFragment3, THIRD_TAB);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(myAdapter);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

}
