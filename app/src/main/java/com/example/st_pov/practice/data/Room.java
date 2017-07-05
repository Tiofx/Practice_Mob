package com.example.st_pov.practice.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by st_pov on 03.07.2017.
 */

public class Room {

    @SerializedName("room")
    @Expose
    private Room_ room;

    public Room_ getRoom() {
        return room;
    }

    public void setRoom(Room_ room) {
        this.room = room;
    }

}