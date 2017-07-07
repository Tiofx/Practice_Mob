package com.example.st_pov.practice.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.st_pov.practice.PagerAdapter;
import com.example.st_pov.practice.R;
import com.example.st_pov.practice.models.Hotel;
import com.example.st_pov.practice.util.Constants;
import com.google.gson.Gson;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by st_pov on 29.06.2017.
 */

public class MainActivity extends HeaderActivity {
    PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.listhotel)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.top5)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        ButterKnife.bind(this);
        getHeader();
    }


    @OnClick(R.id.fab)
    public void addHotel(View view) {
        Intent intent = new Intent(MainActivity.this, HotelAddActivity.class);
        startActivityForResult(intent, Constants.HOTEL_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.HOTEL_REQUEST_CODE && data != null) {
            String result = data.getExtras().getString("new_hotel", "");
            Hotel hotel = new Gson().fromJson(result, Hotel.class);
            if (hotel != null) {
                //TODO: delete stab
                hotel.setPhoto(R.drawable.cosmos_moscow);

                adapter.getTab1().getHotelList().add(hotel);
            }
        }
    }
}