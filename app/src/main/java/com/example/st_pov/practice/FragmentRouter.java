package com.example.st_pov.practice;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.st_pov.practice.tabs.RoomFragment;

/**
 * Created by st_pov on 05.07.2017.
 */

public class FragmentRouter {
    Fragment fragment;
    public static void showFragment(Context mConext, Fragment fragment){
        Context context;
        fragment = this.fragment;
        Fragment fragment = new RoomFragment();
        FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.items, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
