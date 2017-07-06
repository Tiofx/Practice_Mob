package com.example.st_pov.practice.network;

import com.example.st_pov.practice.data.Hotel_;
import com.example.st_pov.practice.data.Room_;

/**
 * Created by st_pov on 04.07.2017.
 */

public class JSONResponse {
    private Hotel_[] hotel;
    private Room_[] room;

    public Hotel_[] getHotel() {
        return hotel;
    }

    public Room_[] getRoom() {
        return room;
    }
}