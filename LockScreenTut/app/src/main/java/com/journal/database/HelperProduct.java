package com.journal.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.journal.database.model.Product;

import java.util.ArrayList;
import java.util.List;

public class HelperProduct extends DBHelper {

    public HelperProduct(Context context) {
        super(context);
    }

    public long insertProduct(String product) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Product.COLUMN_TITLE, product);

        // insert row
        long id = db.insert(Product.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    /**
     * Insert Product object
     * @param product object to insert
     * @return new inserted object ID
     */
    public long insertProduct(Product product) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        values.put(Product.COLUMN_TITLE, product.getTitle());
        values.put(Product.COLUMN_BRIEF, product.getBrief());
        values.put(Product.COLUMN_POST, product.getPost());
        values.put(Product.COLUMN_IMG, product.getImg());
//        values.put(Product.COLUMN_TIMESTAMP, product.getTimestamp());

        // insert row
        long id = db.insert(Product.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    /**
     * Extract an product
     * @param id for the selected product
     * @return selected product
     */
    public Product getProduct(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Product.TABLE_NAME,
                new String[]{Product.COLUMN_ID, Product.COLUMN_TIMESTAMP,
                        Product.COLUMN_TITLE, Product.COLUMN_BRIEF,
                        Product.COLUMN_POST,
                        Product.COLUMN_IMG},
                Product.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        Product product = new Product(
                cursor.getInt(cursor != null ? cursor.getColumnIndex(Product.COLUMN_ID) : 0),
                cursor.getString(cursor.getColumnIndex(Product.COLUMN_TIMESTAMP)),
                cursor.getString(cursor.getColumnIndex(Product.COLUMN_TITLE)),
                cursor.getString(cursor.getColumnIndex(Product.COLUMN_BRIEF)),
                cursor.getString(cursor.getColumnIndex(Product.COLUMN_POST)),
                cursor.getInt(cursor.getColumnIndex(Product.COLUMN_IMG))
                );

        // close the db connection
        cursor.close();

        return product;
    }

    public List<Product> getAll() {
        List<Product> entries = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Product.TABLE_NAME + " ORDER BY " +
                Product.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setId(cursor.getInt(cursor.getColumnIndex(Product.COLUMN_ID)));
                product.setTimestamp(cursor.getString(cursor.getColumnIndex(Product.COLUMN_TIMESTAMP)));
                product.setTitle(cursor.getString(cursor.getColumnIndex(Product.COLUMN_TITLE)));
                product.setBrief(cursor.getString(cursor.getColumnIndex(Product.COLUMN_BRIEF)));
                product.setBrief(cursor.getString(cursor.getColumnIndex(Product.COLUMN_POST)));
                product.setBrief(cursor.getString(cursor.getColumnIndex(Product.COLUMN_IMG)));

                entries.add(product);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return entries list
        return entries;
    }

    public int count() {
        String countQuery = "SELECT  * FROM " + Product.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

    public int updateProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Product.COLUMN_TITLE, product.getTitle());
        values.put(Product.COLUMN_BRIEF, product.getBrief());
        values.put(Product.COLUMN_POST, product.getPost());
        values.put(Product.COLUMN_IMG, product.getImg());

        // updating row
        return db.update(Product.TABLE_NAME, values, Product.COLUMN_ID + " = ?",
                new String[]{String.valueOf(product.getId())});
    }

    public void deleteProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Product.TABLE_NAME, Product.COLUMN_ID + " = ?",
                new String[]{String.valueOf(product.getId())});
        db.close();
    }
}
