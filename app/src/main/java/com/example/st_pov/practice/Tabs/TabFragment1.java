package com.example.st_pov.practice.Tabs;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import com.example.st_pov.practice.HotelAdapter;
import com.example.st_pov.practice.Models.ItemHotel;
import com.example.st_pov.practice.Models.ItemRoom;
import com.example.st_pov.practice.R;
import com.example.st_pov.practice.RoomAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabFragment1 extends Fragment {
    protected RecyclerView recyclerView;
//    protected HotelAdapter adapterHotel;
//    protected RoomAdapter adapterRoom;
    protected List<ItemHotel> hotelList;
//    protected List<ItemRoom> roomList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);

        recyclerView = view.findViewById(R.id.items);

        hotelList = new ArrayList<>();
//        adapterHotel = new HotelAdapter(getContext(), hotelList);
////        roomList = new ArrayList<>();
////        adapterRoom = new RoomAdapter(getContext(), roomList);
//        recyclerView.setAdapter(adapterHotel);


        return view;
    }
//    @Override
//    public void onResume() {
//        super.onResume();
//        ((HotelAdapter) adapterHotel).setOnItemClickListener(new HotelAdapter.MyClickListener() {
//            @Override
//            public void onItemClick(int position, View v) {
//
//            }
//        });
//    }
}