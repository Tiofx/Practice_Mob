package com.example.st_pov.practice.tabs;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.st_pov.practice.HotelAdapter;
import com.example.st_pov.practice.RoomAdapter;
import com.example.st_pov.practice.models.ItemHotel;
import com.example.st_pov.practice.R;
import com.example.st_pov.practice.models.ItemRoom;

import java.util.ArrayList;
import java.util.List;

public class TabFragment1 extends Fragment {
    protected RecyclerView recyclerView;
    protected RoomAdapter roomAdapter;
    protected HotelAdapter adapterHotel;
    protected List<ItemHotel> hotelList;
    protected List<ItemRoom> roomList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);

        recyclerView = view.findViewById(R.id.items);

        hotelList = new ArrayList<>();
//        adapterHotel = new HotelAdapter(getContext(), hotelList);
//        roomList = new ArrayList<>();

        hotelList.add(new ItemHotel("Cosmos", "Moscow", 32, R.drawable.room, 3.0, true));
        hotelList.add(new ItemHotel("Intercontinental", "Madrid", 32, R.drawable.gostin_fgb, 3.0, true));

        adapterHotel = new HotelAdapter(getContext(), hotelList);
        recyclerView.setAdapter(adapterHotel);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapterHotel.setOnItemClickListener(new HotelAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                roomAdapter = new RoomAdapter(getContext(), roomList);
                recyclerView.setAdapter(roomAdapter);
            }
        });
    }
}