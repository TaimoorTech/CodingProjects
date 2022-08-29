package com.example.dbms_cs031_cs010_cs006_cs008;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import java.util.ArrayList;

public class checker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checker);

        ArrayList<Bitmap> images_arrayList = new ArrayList<>();
        ArrayList<String> names_arrayList = new ArrayList<>();
        ArrayList<String> prices_arrayList = new ArrayList<>();
        ArrayList<Float> rate_arrayList = new ArrayList<>();
        ArrayList<String> quantity_arrayList = new ArrayList<>();


        order_database getting = new order_database(checker.this);
        Cursor row = getting.get_info();
        while (row.moveToNext()){
            names_arrayList.add(row.getString(1));
            rate_arrayList.add(Float.valueOf(row.getString(3)));
            prices_arrayList.add(row.getString(6));
            quantity_arrayList.add(row.getString(5));
            byte[] img = row.getBlob(7);
            Bitmap item_image = BitmapFactory.decodeByteArray(img, 0, img.length);
            images_arrayList.add(item_image);
        }

        RecyclerView last_screen_recycler = findViewById(R.id.checker);
        cart_last_screen_recycler adapter = new cart_last_screen_recycler(checker.this,
                names_arrayList, images_arrayList, rate_arrayList, prices_arrayList, quantity_arrayList);
        adapter.filter(checker.this,
                names_arrayList, images_arrayList, rate_arrayList, prices_arrayList, quantity_arrayList);
        last_screen_recycler.setLayoutManager(new LinearLayoutManager(checker.this));
        last_screen_recycler.setAdapter(adapter);

    }
}