package com.example.st_pov.practice.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.st_pov.practice.HotelAdapter;
import com.example.st_pov.practice.R;
import com.example.st_pov.practice.models.ItemHotel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by st_pov on 29.06.2017.
 */

public class TabFragment2 extends Fragment {
    protected HotelAdapter adapterHotel;
    protected List<ItemHotel> hotelList;

    @BindView(R.id.items)
    protected RecyclerView recyclerView;

    final static int BEST_NUMBER = 5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_2, container, false);
        ButterKnife.bind(this, view);

        hotelList = new ArrayList<>();


        adapterHotel = new HotelAdapter(getContext(), hotelList);
        recyclerView.setAdapter(adapterHotel);


//        // TODO: 06/07/2017 request to server
//        baseRetrofit()
//                .create(HotelApi.class)
//                .getTheBestHotels(BEST_NUMBER)
//                .enqueue(new Callback<List<Hotel>>() {
//                    @Override
//                    public void onResponse(Call<List<Hotel>> call,
//                                           Response<List<Hotel>> response) {
//                        if (response.isSuccessful()) {
        stab();
////                            hotelList.addAll(response.body())
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<com.example.st_pov.practice.models.Hotel>> call,
//                                          Throwable t) {
//                        Log.d("rest", "Ошибка аааа!");
//                    }
//                });

        return view;
    }

    private void stab() {
        hotelList.add(new ItemHotel("Best1", "Moscow", 32, R.drawable.gostin_fgb, 2.0, true));
        hotelList.add(new ItemHotel("best2", "Madrid", 123, R.color.blue, 1.0, true));
        hotelList.add(new ItemHotel("best 3", "Moscow", 2, R.color.orange, 5.0, true));
        hotelList.add(new ItemHotel("best 4", "Madrid", 4, R.drawable.gostin_fgb, 4.0, true));
        hotelList.add(new ItemHotel("best 5", "Madrid", 1233, R.drawable.gostin_fgb, 3.0, true));
    }
}