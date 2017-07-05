package com.example.st_pov.practice.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by st_pov on 03.07.2017.
 */

public class Hotel_ {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("numRevs")
    @Expose
    private long numRevs;
    @SerializedName("numStars")
    @Expose
    private long numStars;
    @SerializedName("breakfast")
    @Expose
    private boolean breakfast;
    @SerializedName("rooms")
    @Expose
    private List<Room> rooms = null;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getNumRevs() {
        return numRevs;
    }

    public void setNumRevs(long numRevs) {
        this.numRevs = numRevs;
    }

    public long getNumStars() {
        return numStars;
    }

    public void setNumStars(long numStars) {
        this.numStars = numStars;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

}