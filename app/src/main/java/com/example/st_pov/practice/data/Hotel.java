package com.example.st_pov.practice.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by st_pov on 03.07.2017.
 */

public class Hotel {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("numberStars")
    @Expose
    private long numberStars;
    @SerializedName("numberReviews")
    @Expose
    private long numberReviews;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("breakfast")
    @Expose
    private boolean breakfast;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getNumberStars() {
        return numberStars;
    }

    public void setNumberStars(long numberStars) {
        this.numberStars = numberStars;
    }

    public long getNumberReviews() {
        return numberReviews;
    }

    public void setNumberReviews(long numberReviews) {
        this.numberReviews = numberReviews;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

}