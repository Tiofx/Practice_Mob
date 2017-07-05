package com.example.st_pov.practice.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by st_pov on 04.07.2017.
 */

public class Room_ {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("price")
    @Expose
    private long price;
    @SerializedName("people")
    @Expose
    private long people;

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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPeople() {
        return people;
    }

    public void setPeople(long people) {
        this.people = people;
    }

}