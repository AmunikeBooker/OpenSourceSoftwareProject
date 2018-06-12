package com.journal.database.model;

/**
 * Created by dell on 5/6/2018.
 */

public class Product {

    private int id;
    private String title, shortdesc;
    private double rating;
    private double price;
    private int img;

    public Product(int id, String title, String shortdesc, double rating, double price, int img) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.rating = rating;
        this.price = price;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public int getImg() {
        return img;
    }
}
