package com.example.st_pov.practice.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by st_pov on 03.07.2017.
 */

public class Client {


    public static final String BASE_URL = "http://lingering-flower-2750.getsandbox.com/";
    private static Retrofit retrofit = null;


    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}