package com.example.cew_cep_cs031_cs010_cs006;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class books extends AppCompatActivity {
    ImageView list_page_cart;
    RecyclerView recyclerView;
    TextView display_names;
    static books instance1;
    static books instance2;
    ArrayList<String> new_back_names = new ArrayList<>();
    ArrayList<Integer> new_back_image = new ArrayList<>();
    String books_title[] = {"Harry Potter and the Philosopher's Stone",
            "Harry Potter and the Chamber of Secrets",
            "Harry Potter and the Prisoner of Azkaban","Amara the Brave", "The Book of Warlock",
            "Hunger Games : Catching Fire", "The Dreaming Arts", "Heart Spring Mountain",
            "The Hypocrite World", "RED Planet", "SEEDS of HATRED", "Torn", "The Girl on the Train"};
    int book_images[] = {R.drawable.harry1, R.drawable.harry2, R.drawable.harry3,
            R.drawable.amarabrave, R.drawable.bookwarlock, R.drawable.catchingfire,
            R.drawable.dreamingarts, R.drawable.heartspringbook, R.drawable.hypocriteworld,
            R.drawable.redplanet, R.drawable.seedshatred, R.drawable.torn, R.drawable.train};

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        list_page_cart = findViewById(R.id.cart2);
        display_names = findViewById(R.id.display_name);
        recyclerView = findViewById(R.id.recyclerView1);
        try {
            ArrayList<String> back_names = displaying_information.getActivityInstance1().getdata1();
            ArrayList<Integer> back_image = displaying_information.getActivityInstance2().getdata2();
            new_back_image = back_image;
            new_back_names = back_names;
        } catch (Exception e) {

        }


        Intent getName =  getIntent();

        String user = getName.getStringExtra("login_name");
        display_names.setText("Welcome " + user);

        list_page_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(books.this, checkout.class);
                startActivity(i);
            }
        });


        recycling_books adapter = new recycling_books(this, books_title, book_images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public static books getActivityInstance1(){
        return instance1;
    }
    public static books getActivityInstance2(){
        return instance2;
    }
    public ArrayList<String> getdata1(){
        return this.new_back_names;
    }
    public ArrayList<Integer> getdata2(){
        return this.new_back_image;
    }
}