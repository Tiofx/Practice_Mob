package com.example.st_pov.practice.Models;

/**
 * Created by st_pov on 29.06.2017.
 */

public class ItemRoom {
    final String name;
    final int price, people;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPeople() {
        return people;
    }

    public ItemRoom(String name, int price, int people) {
        this.name = name;
        this.price = price;
        this.people = people;

    }
}