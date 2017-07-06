package com.example.st_pov.practice.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.st_pov.practice.HotelAdapter;
import com.example.st_pov.practice.R;
import com.example.st_pov.practice.models.Hotel;

import java.util.ArrayList;
import java.util.List;


public class TabFragment1 extends Fragment {
    protected RecyclerView recyclerView;
    protected HotelAdapter adapterHotel;
    protected List<Hotel> hotelList;


    public List<Hotel> getHotelList() {
        return hotelList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);

        recyclerView = view.findViewById(R.id.itemsHotels);

        hotelList = new ArrayList<>();
//        adapterHotel = new HotelAdapter(getContext(), hotelList);
//        roomList = new ArrayList<>();

//        baseRetrofit()
//                .create(HotelApi.class)
//                .getAllHotels()
//                .enqueue(new Callback<List<com.example.st_pov.practice.models.Hotel>>() {
//                    @Override
//                    public void onResponse(Call<List<com.example.st_pov.practice.models.Hotel>> call,
//                                           Response<List<com.example.st_pov.practice.models.Hotel>> response) {
//                        if (response.isSuccessful() && response.body() != null) {
//                            hotelList.addAll(response.body());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<com.example.st_pov.practice.models.Hotel>> call,
//                                          Throwable t) {
//                        Log.d("rest", "Ошибка аааа!");
//                    }
//                });

        hotelList.add(new Hotel("Cosmos", "Moscow", 32, R.drawable.room, 3, true));
        hotelList.add(new Hotel("Intercontinental", "Madrid", 32, R.drawable.gostin_fgb, 3, true));

        adapterHotel = new HotelAdapter(getContext(), hotelList);
        recyclerView.setAdapter(adapterHotel);

        return view;
    }
}