package com.example.cew_cep_cs031_cs010_cs006;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class displaying_information extends AppCompatActivity{
    ArrayList<String> let_names = new ArrayList<>();
    ArrayList<Integer> let_image = new ArrayList<>();
    ArrayList<String> let_Stars = new ArrayList<>();
    TextView inform;
    TextView title_get;
    ImageView img;
    ImageView information_page_cart;
    private String[] text;
    ImageView adding;
    String user_name;
    TextView findinglocation4;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaying_information);

        findinglocation4 = findViewById(R.id.location4);
        information_page_cart = findViewById(R.id.cart);
        adding = findViewById(R.id.clicking);
        inform = findViewById(R.id.informations);
        img = findViewById(R.id.retrieve_image);
        title_get = findViewById(R.id.titlediplay);
        books_description contents = new books_description();
        text = contents.get_description();

        findinglocation4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(displaying_information.this, MapsActivity.class);
                startActivity(i3);
            }
        });


        information_page_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(displaying_information.this, checkout.class);
                i1.putStringArrayListExtra("names", let_names);
                i1.putIntegerArrayListExtra("im", let_image);
                i1.putStringArrayListExtra("rat", let_Stars);
                i1.putExtra("n2", user_name);
                startActivity(i1);
            }
        });

        adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adding.setImageResource(R.drawable.tick);
                Toast.makeText(displaying_information.this, "The Book is added to your cart",
                        Toast.LENGTH_SHORT).show();
                Intent setting = getIntent();
                String name = setting.getStringExtra("title");
                int put_image = setting.getIntExtra("image_resource",1);
                String rate = setting.getStringExtra("rating");
                user_name = setting.getStringExtra("n1");
                let_Stars.add(rate);
                let_names.add(name);
                let_image.add(put_image);

            }
        });

        Intent retrieving = getIntent();
        String name = retrieving.getStringExtra("title");
        int put_image = retrieving.getIntExtra("image_resource",1);
        int pos = retrieving.getIntExtra("num", 1);


        img.setImageResource(put_image);
        title_get.setText("Title Of Book : \n" + name);
        inform.setText("Description : \n" + text[pos]);
    }
}