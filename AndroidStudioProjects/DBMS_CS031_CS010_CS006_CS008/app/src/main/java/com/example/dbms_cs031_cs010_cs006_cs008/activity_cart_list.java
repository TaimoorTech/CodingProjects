package com.example.dbms_cs031_cs010_cs006_cs008;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class activity_cart_list extends AppCompatActivity {
    //private RecyclerView.Adapter adapter;
    //private RecyclerView recyclerViewList;
    //TextView itemstotaltxt, deliverytotaltxt, taxtotaltxt, totaltxt, cartisemptytxt, headingmycart, itemstotalheading, deliveryservicesheading, taxheading, totalheading, checkout_btn;
    //private ScrollView scrollview;
    ArrayList<Bitmap> images_arrayList = new ArrayList<>();
    ArrayList<Bitmap> images_arrayList_edited = new ArrayList<>();
    ArrayList<String> names_arrayList = new ArrayList<>();
    ArrayList<String> prices_arrayList = new ArrayList<>();
    ArrayList<Float> rates = new ArrayList<>();
    ArrayList<String> quantity_arrayList = new ArrayList<>();
    //order_database ordering;
    Context context;

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Bitmap> new_images_arrayList = new ArrayList<>();
        ArrayList<String> new_names_arrayList = new ArrayList<>();
        ArrayList<String> new_prices_arrayList = new ArrayList<>();
        ArrayList<Float> new_rates = new ArrayList<>();
        ArrayList<String> new_quantity_arrayList = new ArrayList<>();

        int tax = 200;
        int charges = 500;
        int total_count = 0;

        RecyclerView recycler_cart_list = findViewById(R.id.recycler_cartlist);
        TextView item_total_txt = findViewById(R.id.itemstotaltxt);
        TextView delivery_txt = findViewById(R.id.deliverytotaltxt);
        TextView tax_txt = findViewById(R.id.taxtotaltxt);
        TextView total_txt= findViewById(R.id.totaltxt);
        TextView cart_is_empty_txt = findViewById(R.id.cartisemptytxt);
        TextView heading_my_cart = findViewById(R.id.headingmycart);
        TextView items_total_heading = findViewById(R.id.itemstotalheading);
        TextView delivery_services_heading = findViewById(R.id.deliveryservicesheading);
        TextView tax_heading = findViewById(R.id.taxheading);
        TextView checkout_btn = findViewById(R.id.checkout_btn);

        /////DATABASE ACCESS FUNCTIONALITY////
        order_database getting = new order_database(activity_cart_list.this);
        Cursor row = getting.get_info();
        while (row.moveToNext()) {
            new_names_arrayList.add(row.getString(1));
            new_rates.add(Float.valueOf(row.getString(3)));
            new_prices_arrayList.add(row.getString(6));
            new_quantity_arrayList.add(row.getString(5));
            byte[] img = row.getBlob(7);
            Bitmap item_image = BitmapFactory.decodeByteArray(img, 0, img.length);
            new_images_arrayList.add(item_image);
        }
        for (int i=0; i<new_prices_arrayList.size(); i++){
            total_count = total_count + Integer.parseInt(new_prices_arrayList.get(i));
        }

        if (new_names_arrayList.isEmpty()){
            cart_is_empty_txt.setVisibility(View.VISIBLE);
            total_txt.setText("Rs 0");
        }
        String rup = "Rs.";
        item_total_txt.setText(rup.concat(String.valueOf(total_count)));
        int full_total = 0;
        if (total_count == 0){
            full_total = 0;
        }
        else {
            full_total = tax+charges+total_count;
        }
        total_txt.setText(rup.concat(String.valueOf(full_total)));
        Cart_Adapter cart_adapter = new Cart_Adapter(activity_cart_list.this,
                new_names_arrayList, new_images_arrayList, new_rates,
                new_prices_arrayList, new_quantity_arrayList, item_total_txt, total_txt, cart_is_empty_txt);
        cart_adapter.filter(activity_cart_list.this, new_images_arrayList, new_names_arrayList, new_rates,
                new_prices_arrayList, new_quantity_arrayList, item_total_txt, total_txt, cart_is_empty_txt);
        recycler_cart_list.setLayoutManager(new LinearLayoutManager(activity_cart_list.this));
        recycler_cart_list.setAdapter(cart_adapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(ContextCompat.getColor(activity_cart_list.this, R.color.white));

        int tax = 200;
        int charges = 500;
        int total_count = 0;

        setContentView(R.layout.activity_cart_list);
        RecyclerView recycler_cart_list = findViewById(R.id.recycler_cartlist);
        TextView item_total_txt = findViewById(R.id.itemstotaltxt);
        TextView delivery_txt = findViewById(R.id.deliverytotaltxt);
        TextView tax_txt = findViewById(R.id.taxtotaltxt);
        TextView total_txt= findViewById(R.id.totaltxt);
        TextView cart_is_empty_txt = findViewById(R.id.cartisemptytxt);
        TextView heading_my_cart = findViewById(R.id.headingmycart);
        TextView items_total_heading = findViewById(R.id.itemstotalheading);
        TextView delivery_services_heading = findViewById(R.id.deliveryservicesheading);
        TextView tax_heading = findViewById(R.id.taxheading);
        TextView checkout_btn = findViewById(R.id.checkout_btn);

        /////DATABASE ACCESS FUNCTIONALITY////
        order_database getting = new order_database(activity_cart_list.this);
        Cursor row = getting.get_info();
        while (row.moveToNext()) {
            names_arrayList.add(row.getString(1));
            rates.add(Float.valueOf(row.getString(3)));
            prices_arrayList.add(row.getString(6));
            quantity_arrayList.add(row.getString(5));
            byte[] img = row.getBlob(7);
            Bitmap item_image = BitmapFactory.decodeByteArray(img, 0, img.length);
            images_arrayList.add(item_image);
        }

        for (int i=0; i<prices_arrayList.size(); i++){
            total_count = total_count + Integer.parseInt(prices_arrayList.get(i));
        }

        checkout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity_cart_list.this,
                        order_completion.class);
                startActivity(i);
            }
        });
        if (names_arrayList.isEmpty()){
            cart_is_empty_txt.setVisibility(View.VISIBLE);
            total_txt.setText("Rs 0");
        }
        else{
            String rup = "Rs.";
            item_total_txt.setText(rup.concat(String.valueOf(total_count)));
            int full_total = tax+charges+total_count;
            total_txt.setText(rup.concat(String.valueOf(full_total)));
            Cart_Adapter cart_adapter = new Cart_Adapter(activity_cart_list.this, names_arrayList, images_arrayList, rates,
                    prices_arrayList, quantity_arrayList, item_total_txt, total_txt, cart_is_empty_txt);
            cart_adapter.filter(activity_cart_list.this, images_arrayList, names_arrayList, rates,
                    prices_arrayList, quantity_arrayList, item_total_txt, total_txt, cart_is_empty_txt);
            recycler_cart_list.setLayoutManager(new LinearLayoutManager(activity_cart_list.this));
            recycler_cart_list.setAdapter(cart_adapter);

        }
    }
}