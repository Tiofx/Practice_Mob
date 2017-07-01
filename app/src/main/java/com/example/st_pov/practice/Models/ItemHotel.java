package com.example.st_pov.practice.Models;

/**
 * Created by st_pov on 29.06.2017.
 */

public class ItemHotel {
    final String name, address;
    final int numberReviews, photoHotel;
    final double numberStars;
    final boolean isBreakfast;

    public ItemHotel(String name, int price, String address, int numberReviews, int photoHotel, double numberStars, boolean isBreakfast) {
        this.name = name;
        this.address = address;
        this.numberReviews = numberReviews;
        this.photoHotel = photoHotel;
        this.numberStars = numberStars;
        this.isBreakfast = isBreakfast;

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNumberReviews() {
        return numberReviews;
    }

    public double getNumberStars() {
        return numberStars;
    }

    public boolean isBreakfast() {
        return isBreakfast;
    }

    public int getPhotoHotel() {
        return photoHotel;
    }
}
