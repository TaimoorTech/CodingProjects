package com.example.cew_cep_cs031_cs010_cs006;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class displaying_information extends AppCompatActivity {
    ArrayList<String[]> s = new ArrayList<>();
    TextView inform;
    TextView title_get;
    ImageView img;
    ImageView information_page_cart;
    private String[] text;
    ImageView adding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaying_information);

        information_page_cart = findViewById(R.id.cart);
        adding = findViewById(R.id.clicking);
        inform = findViewById(R.id.informations);
        img = findViewById(R.id.retrieve_image);
        title_get = findViewById(R.id.titlediplay);
        books_description contents = new books_description();
        text = contents.get_description();

        information_page_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(displaying_information.this, checkout.class);
                i.putStringArrayListExtra("list", (ArrayList<String>) s);
                startActivity(i);
            }
        });

        adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adding.setImageResource(R.drawable.tick);
                Toast.makeText(displaying_information.this, "The Book is added to your cart",
                        Toast.LENGTH_SHORT).show();
            }
        });


        Intent retrieving = getIntent();
        String name = retrieving.getStringExtra("title");
        int put_image = retrieving.getIntExtra("image_resource",1);
        int pos = retrieving.getIntExtra("num", 1);
        String[] p = {name, Integer.toString(put_image)};
        s.add(p);

        img.setImageResource(put_image);
        title_get.setText("Title Of Book : \n" + name);
        inform.setText("Description : \n" + text[pos]);

    }
}