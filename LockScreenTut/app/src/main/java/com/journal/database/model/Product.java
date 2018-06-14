package com.journal.database.model;

/**
 * Created by Mimi on 6/14/2018.
 */

public class Product {

    public static final String TABLE_NAME = "products";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_BRIEF = "brief";
    public static final String COLUMN_POST = "post";
    public static final String COLUMN_PATH = "path";
    public static final String COLUMN_IMG = "img";


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP,"
                    + COLUMN_TITLE + " TEXT DEFAULT '',"
                    + COLUMN_BRIEF + " TEXT DEFAULT '',"
                    + COLUMN_POST + " TEXT DEFAULT '', "
                    + COLUMN_PATH + " TEXT DEFAULT '', "
                    + COLUMN_IMG + " INTEGER "
                    + ")";
    
    private int id;
    private String title, brief, timestamp, post, path;
    private double rating;
    private double price;
    private int img;

    public Product(){}

    public Product(int id, String title, String brief, double rating, 
                   double price, int img) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.rating = rating;
        this.price = price;
        this.img = img;
    }

    public Product(int id, String timestamp, String title,
                   String brief,  String post, String path,
                    int img) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.post = post;
        this.timestamp = timestamp;
        this.path = path;
        this.img = img;
    }

    public Product(int id, String timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public Product(int id, String timestamp, String title) {
        this.id = id;
        this.timestamp = timestamp;
        this.title = title;
    }

    public Product(int id, String timestamp, String title, String brief) {
        this.id = id;
        this.timestamp = timestamp;
        this.title = title;
        this.brief = brief;
    }

    public Product(int id, String timestamp, String title, String brief,
                 String post) {
        this.id = id;
        this.timestamp = timestamp;
        this.title = title;
        this.brief = brief;
        this.post = post;
    }

    public Product(String title, String brief) {
        this.title = title;
        this.brief = brief;
    }
    
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBrief() {
        return brief;
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

    public String getTimestamp() {
        return timestamp;
    }

    public String getPost() {
        return post;
    }

    public String getPath() {
        return path;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

