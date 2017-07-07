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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.st_pov.practice.util.RetrofitKt.baseRetrofit;


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
        adapterHotel = new HotelAdapter(getContext(), hotelList);
        recyclerView.setAdapter(adapterHotel);

        baseRetrofit(false)
                .create(HotelApi.class)
                .getAllHotels()
                .enqueue(new Callback<List<Hotel>>() {
                    @Override
                    public void onResponse(Call<List<Hotel>> call,
                                           Response<List<Hotel>> response) {
                        List<Hotel> body = response.body();
                        if (response.isSuccessful() && body != null) {
                            for (Hotel hotel : body) {
                                hotel.setPhoto(R.drawable.room);
                            }
                            hotelList.addAll(body);
                            adapterHotel.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<com.example.st_pov.practice.models.Hotel>> call,
                                          Throwable t) {
                        Log.d("rest", "Ошибка!" + t);
                    }
                });

//        Hotel hotel = new Hotel("Cosmos", "Moscow", 32, R.drawable.room, 3, true);
//        hotel.setPrice(100);
//        hotel.setRoomDescription("Это заглушка за 100 долларов");
//        hotelList.add(hotel);
//
//        hotel = new Hotel("Intercontinental", "Madrid", 32, R.drawable.gostin_fgb, 3, true);
//        hotel.setPrice(123);
//        hotel.setRoomDescription("Это заглушка за 123 доллара!!!!");
//        hotelList.add(hotel);

        return view;
    }
}