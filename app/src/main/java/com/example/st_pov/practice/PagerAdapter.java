package com.example.st_pov.practice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.st_pov.practice.tabs.TabFragment1;
import com.example.st_pov.practice.tabs.TabFragment2;

/**
 * Created by st_pov on 29.06.2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    Fragment[] fragments = new Fragment[2];
    TabFragment1 tab1;

    public TabFragment1 getTab1() {
        return tab1;
    }

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;

        tab1 = new TabFragment1();
        fragments[0] = tab1;
        fragments[1] = new TabFragment2();
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments.length > position) {
            return fragments[position];
        } else return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}