package com.journal.lockscreentut;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.journal.database.HelperProduct;
import com.journal.database.model.Product;

import java.io.FileNotFoundException;

public class AddActivity extends AppCompatActivity {

    private String path;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        String key = "key";
        path = intent.getStringExtra(key); //if it's a string you stored.

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        image = (ImageView)findViewById(R.id.image);
    }

    public void loadImage()
    {
        image.setImageBitmap(null);
//        note.setText("by Back Uri");

        try {
            Bitmap bm = BitmapFactory.decodeFile(path);
            image.setImageBitmap(bm);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void submit(View button) {
        // Do click handling here
        Toast.makeText(this,
                "Photo " + path,
                Toast.LENGTH_SHORT).show();

        HelperProduct adapter = new HelperProduct(this);
        Product product = new Product();
        EditText tv_title = this.findViewById(R.id.TextTitle);
        EditText tv_brief = this.findViewById(R.id.TextBrief);
        product.setTitle(tv_title.getText().toString());
        product.setBrief(tv_brief.getText().toString());
        product.setPath(path);

        adapter.insertProduct(product);

        Intent myIntent = new Intent(AddActivity.this, MainActivity.class);
        AddActivity.this.startActivity(myIntent);
    }
}
