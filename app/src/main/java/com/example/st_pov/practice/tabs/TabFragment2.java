package com.example.st_pov.practice.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.st_pov.practice.HotelAdapter;
import com.example.st_pov.practice.R;
import com.example.st_pov.practice.models.Hotel;
import com.example.st_pov.practice.service.HotelApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.st_pov.practice.util.RetrofitKt.baseRetrofit;

/**
 * Created by st_pov on 29.06.2017.
 */

public class TabFragment2 extends Fragment {
    protected HotelAdapter adapterHotel;
    protected List<Hotel> hotelList;

    @BindView(R.id.items)
    protected RecyclerView recyclerView;

//    final static int BEST_NUMBER = 5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_2, container, false);
        ButterKnife.bind(this, view);

        hotelList = new ArrayList<>();


        adapterHotel = new HotelAdapter(getContext(), hotelList);
        recyclerView.setAdapter(adapterHotel);

//        stab();

        baseRetrofit(false)
                .create(HotelApi.class)
                .getAllHotels()
//                .getTheBestHotels(BEST_NUMBER)
                .enqueue(new Callback<List<Hotel>>() {
                    @Override
                    public void onResponse(Call<List<Hotel>> call,
                                           Response<List<Hotel>> response) {
                        List<Hotel> body = response.body();
                        if (response.isSuccessful() && body != null) {
                            for (Hotel hotel : body) {
                                hotel.setPhoto(R.drawable.gostin_fgb);
                            }
                            hotelList.addAll(body);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<com.example.st_pov.practice.models.Hotel>> call,
                                          Throwable t) {
                        Log.d("rest", "Ошибка!" + t);
                    }
                });

        return view;
    }

    private void stab() {
        hotelList.add(new Hotel("Best1", "Moscow", 32, R.drawable.gostin_fgb, 2, true));
        hotelList.add(new Hotel("best2", "Madrid", 123, R.color.blue, 1, true));
        hotelList.add(new Hotel("best 3", "Moscow", 2, R.color.orange, 5, true));
        hotelList.add(new Hotel("best 4", "Madrid", 4, R.drawable.gostin_fgb, 4, true));
        hotelList.add(new Hotel("best 5", "Madrid", 1233, R.drawable.gostin_fgb, 3, true));
    }
}