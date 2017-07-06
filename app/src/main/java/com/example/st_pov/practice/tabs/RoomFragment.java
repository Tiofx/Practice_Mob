package com.example.st_pov.practice.tabs;

/**
 * Created by st_pov on 03.07.2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.st_pov.practice.HotelAdapter;
import com.example.st_pov.practice.R;
import com.example.st_pov.practice.RoomAdapter;
import com.example.st_pov.practice.models.ItemHotel;
import com.example.st_pov.practice.models.ItemRoom;

import java.util.ArrayList;
import java.util.List;

public class RoomFragment extends Fragment {
    protected RecyclerView recyclerView;
    protected RoomAdapter roomAdapter;
    protected List<ItemRoom> roomList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);

        recyclerView = view.findViewById(R.id.items);
        roomList = new ArrayList<>();

        roomList.add(new ItemRoom("Cosmos", 500, 32, R.drawable.room));
        roomList.add(new ItemRoom("Intercontinental", 200, 32, R.drawable.gostin_fgb));

        roomAdapter = new RoomAdapter(getContext(), roomList);
        recyclerView.setAdapter(roomAdapter);


        return view;
    }
}