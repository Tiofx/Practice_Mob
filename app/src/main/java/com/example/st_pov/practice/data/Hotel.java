package com.example.st_pov.practice.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by st_pov on 04.07.2017.
 */

public class Hotel {

    @SerializedName("hotel")
    @Expose
    private Hotel hotel;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}