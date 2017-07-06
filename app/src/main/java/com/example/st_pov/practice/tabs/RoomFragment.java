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
import com.example.st_pov.practice.data.Room;
import com.example.st_pov.practice.data.Room_;
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

import static android.content.ContentValues.TAG;

/**
 * Created by st_pov on 05.07.2017.
 */

public class RoomFragment extends Fragment {
    protected RecyclerView recyclerView;
    protected RoomAdapter roomAdapter;
    protected List<ItemRoom> roomList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.room_fragment, container, false);

        recyclerView = view.findViewById(R.id.itemsRooms);

        roomList = new ArrayList<>();

        roomList.add(new ItemRoom("Cosmos", 500, 32, R.drawable.room));
        roomList.add(new ItemRoom("Space", 100, 6, R.drawable.continental_italy));

        roomAdapter = new RoomAdapter(getContext(), roomList);
        recyclerView.setAdapter(roomAdapter);

        loadJSON();
        return view;
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://lingering-flower-2750.getsandbox.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface api = retrofit.create(RequestInterface.class);
        Call<List<Room_>> call = api.getRooms();
        call.enqueue(new Callback<List<Room_>>() {
            @Override
            public void onResponse(Call<List<Room_>> call, Response<List<Room_>> response) {
                if (response.isSuccessful()) {
                    roomList = new ArrayList<>();

                    roomAdapter = new RoomAdapter(roomList);
                    recyclerView.setAdapter(roomAdapter);
                }
//                JSONResponse jsonResponse = response.body();
//                data = new ArrayList<>(Arrays.asList(jsonResponse.getHotel()));
//                adapterHotel = new HotelAdapter(data);
//                recyclerView.setAdapter(adapterHotel);
            }

            @Override
            public void onFailure(Call<List<Room_>> call, Throwable t) {
                Log.d("Error", t.getMessage());
                Toast.makeText(getContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        });
    }
}