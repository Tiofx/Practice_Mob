package com.example.st_pov.practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.st_pov.practice.activities.HeaderActivity;
import com.example.st_pov.practice.activities.HotelAddActivity;
import com.example.st_pov.practice.models.Hotel;
import com.example.st_pov.practice.models.ItemHotel;
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
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Click action
//                Intent intent = new Intent(MainActivity.this, AddReview.class);
//                startActivity(intent);
//            }
//        });


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.top5)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.listhotel)));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void addHotel(View view) {
        Intent intent = new Intent(this, HotelAddActivity.class);
        startActivityForResult(intent, Constants.HOTEL_REQUEST_CODE);
//        loadActivity(MainActivity.this, HotelAddActivity.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.HOTEL_REQUEST_CODE) {
            String result = data.getExtras().getString("new_hotel", "");
            Hotel hotel = new Gson().fromJson(result, Hotel.class);
            if (hotel != null) {
                adapter.getTab1().getHotelList().add(new ItemHotel(
                        hotel.getTitle(),
                        hotel.getAddress(),
                        0,
//                        hotel.getReviewsNumber(),
                        R.drawable.gostin_fgb,
                        hotel.getStarRating(),
                        hotel.getHasBreakfast()
                ));
            }
        }
    }
}