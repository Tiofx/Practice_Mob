package com.example.st_pov.practice.api;

import com.example.st_pov.practice.HotelAdapter;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by st_pov on 03.07.2017.
 */

public interface ApiService {

    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of ContactList
    */
    @GET("/lessons/retrofit-json/json_data.json")
    Call<HotelAdapter> getMyJSON();
}