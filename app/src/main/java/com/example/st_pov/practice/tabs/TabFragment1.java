package com.example.st_pov.practice.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.st_pov.practice.HotelAdapter;
import com.example.st_pov.practice.R;
import com.example.st_pov.practice.RoomAdapter;
import com.example.st_pov.practice.data.Hotel;
import com.example.st_pov.practice.models.ItemHotel;
import com.example.st_pov.practice.models.ItemRoom;
import com.example.st_pov.practice.network.RequestInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import com.example.st_pov.practice.HotelAdapter;

public class TabFragment1 extends Fragment {
    protected RecyclerView recyclerView;
    protected RoomAdapter roomAdapter;
    protected HotelAdapter adapterHotel;
    protected List<ItemHotel> hotelList;
    protected List<ItemRoom> roomList;


    public List<ItemHotel> getHotelList() {
        return hotelList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);

        recyclerView = view.findViewById(R.id.items);

        hotelList = new ArrayList<>();
//        adapterHotel = new HotelAdapter(getContext(), hotelList);
//        roomList = new ArrayList<>();

        // TODO: 06/07/2017 request to server
//        baseRetrofit()
//                .create(HotelApi.class)
//                .getAllHotels()
//                .enqueue(new Callback<List<com.example.st_pov.practice.models.Hotel>>() {
//                    @Override
//                    public void onResponse(Call<List<com.example.st_pov.practice.models.Hotel>> call,
//                                           Response<List<com.example.st_pov.practice.models.Hotel>> response) {
//                        if (response.isSuccessful()) {
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

        hotelList.add(new ItemHotel("Cosmos", "Moscow", 32, R.drawable.room, 3.0, true));
        hotelList.add(new ItemHotel("Intercontinental", "Madrid", 32, R.drawable.gostin_fgb, 3.0, true));

        adapterHotel = new HotelAdapter(getContext(), hotelList);
        recyclerView.setAdapter(adapterHotel);

//        roomList = new ArrayList<>();
////        adapterHotel = new HotelAdapter(getContext(), hotelList);
////        roomList = new ArrayList<>();
//
//        roomList.add(new ItemRoom("Cosmos", 32, 2, R.drawable.room));
//        roomList.add(new ItemRoom("Space", 32, 2, R.drawable.room));
//
//        roomAdapter = new RoomAdapter(getContext(), roomList);
//        recyclerView.setAdapter(roomAdapter);
        loadJSON();


        return view;
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.learn2crack.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface api = retrofit.create(RequestInterface.class);
        Call<List<Hotel>> call = api.getHotels();
        call.enqueue(new Callback<List<Hotel>>() {
            @Override
            public void onResponse(Call<List<Hotel>> call, Response<List<Hotel>> response) {
                if (response.isSuccessful()) {
                    hotelList = new ArrayList<>();
                    List<Hotel> result = response.body();
//                        hotelList = result.get(List<Hotel>);

                    adapterHotel = new HotelAdapter(hotelList);
                    recyclerView.setAdapter(adapterHotel);
                }
//                JSONResponse jsonResponse = response.body();
//                data = new ArrayList<>(Arrays.asList(jsonResponse.getHotel()));
//                adapterHotel = new HotelAdapter(data);
//                recyclerView.setAdapter(adapterHotel);
            }

            @Override
            public void onFailure(Call<List<Hotel>> call, Throwable t) {
                Log.d("Error", t.getMessage());
                Toast.makeText(getContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        adapterHotel.setOnItemClickListener(new HotelAdapter.MyClickListener() {
//            @Override
//            public void onItemClick(int position, View v) {
//                roomAdapter = new RoomAdapter(getContext(), roomList);
//                recyclerView.setAdapter(roomAdapter);
//            }
//        });
//    }
}