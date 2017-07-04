package com.example.st_pov.practice.models;

/**
 * Created by st_pov on 29.06.2017.
 */

public class ItemRoom {
    final String name;
    final int price, people, photoRoom;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPeople() {
        return people;
    }

    public int getPhotoRoom() {
        return photoRoom;
    }

    public ItemRoom(String name, int price, int people, int photoRoom) {
        this.name = name;
        this.price = price;
        this.people = people;
        this.photoRoom = photoRoom;
    }
}