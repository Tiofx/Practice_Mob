package com.example.st_pov.practice.Models;

/**
 * Created by st_pov on 29.06.2017.
 */

public class ItemHotel {
    final String name, adress;
    final int numberReviews;

    public ItemHotel(String name, int price, String adress, int numberReviews) {
        this.name = name;
        this.adress = adress;
        this.numberReviews = numberReviews;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public int getNumberReviews() {
        return numberReviews;
    }
}
