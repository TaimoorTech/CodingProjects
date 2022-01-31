package com.example.cew_cep_cs031_cs010_cs006;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class displaying_information extends AppCompatActivity{
    ArrayList<String> let_names = new ArrayList<>();
    ArrayList<Integer> let_image = new ArrayList<>();
    TextView inform;
    TextView title_get;
    ImageView img;
    ImageView information_page_cart;
    private String[] text;
    ImageView adding;
    static displaying_information instance1;
    static displaying_information instance2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaying_information);
        try {
            ArrayList<String> names = books.getActivityInstance1().getdata1();
            ArrayList<Integer> imsg = books.getActivityInstance2().getdata2();
            let_names = names;
            let_image = imsg;
        }catch (Exception e){

        }
        instance1 = this;
        instance2 = this;
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
//                i.putStringArrayListExtra("names", names);
//                i.putIntegerArrayListExtra("im", imsg);
                startActivity(i);
            }
        });

        adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adding.setImageResource(R.drawable.tick);
                Toast.makeText(displaying_information.this, "The Book is added to your cart",
                        Toast.LENGTH_SHORT).show();
                Intent retrieving = getIntent();
                String name = retrieving.getStringExtra("title");
                int put_image = retrieving.getIntExtra("image_resource",1);
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
    public static displaying_information getActivityInstance1(){
        return instance1;
    }
    public static displaying_information getActivityInstance2(){
        return instance2;
    }
    public ArrayList<String> getdata1(){
        return this.let_names;
    }
    public ArrayList<Integer> getdata2(){
        return this.let_image;
    }


}