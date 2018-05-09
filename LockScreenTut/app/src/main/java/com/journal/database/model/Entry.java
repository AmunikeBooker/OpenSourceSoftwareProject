package com.journal.database.model;

public class Entry {
    public static final String TABLE_NAME = "entries";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_TITTLE = "tittle";
    public static final String COLUMN_BRIEF = "brief";
    public static final String COLUMN_POST = "post";
    public static final String COLUMN_PATH = "path";
//    Images names separate by ;
    public static final String COLUMN_IMAGES = "images";

    private int id;
    private String timestamp;
    private String tittle;
    private String brief;
    private String post;
    private String path;
    private String images;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP,"
                    + COLUMN_TITTLE + " TEXT DEFAULT '',"
                    + COLUMN_BRIEF + " TEXT DEFAULT '',"
                    + COLUMN_POST + " TEXT DEFAULT '',"
                    + COLUMN_PATH + " TEXT DEFAULT '',"
                    + COLUMN_IMAGES + " TEXT DEFAULT ''"
                    + ")";

    public Entry() {
    }

    public Entry(int id, String timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public Entry(int id, String timestamp, String tittle) {
        this.id = id;
        this.timestamp = timestamp;
        this.tittle = tittle;
    }

    public Entry(int id, String timestamp, String tittle, String brief) {
        this.id = id;
        this.timestamp = timestamp;
        this.tittle = tittle;
        this.brief = brief;
    }

    public Entry(int id, String timestamp, String tittle, String brief,
                 String post, String path, String images) {
        this.id = id;
        this.timestamp = timestamp;
        this.tittle = tittle;
        this.brief = brief;
        this.post = post;
        this.path = path;
        this.images = images;
    }

    public Entry(String tittle, String brief) {
        this.tittle = tittle;
        this.brief = brief;
    }

    public int getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getTittle() {
        return tittle;
    }

    public String getBrief() {
        return brief;
    }

    public String getPost() {
        return post;
    }

    public String getPath() {
        return path;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
