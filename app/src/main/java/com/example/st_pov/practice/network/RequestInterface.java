package com.example.st_pov.practice.network;

import com.example.st_pov.practice.data.Hotel;
import com.example.st_pov.practice.data.Hotel_;
import com.example.st_pov.practice.data.Room_;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("/api/hotels")
    Call<List<Hotel>> getHotels();

    @GET("/api/hotels/{id}")
    Call<List<Hotel_>> getHotel();

    @GET("/api/hotels/{id}/rooms")
    Call<List<Room_>> getRooms();

    @GET("/api/hotels/{id}/rooms/{id}")
    Call<List<Room_>> getRoom();
}