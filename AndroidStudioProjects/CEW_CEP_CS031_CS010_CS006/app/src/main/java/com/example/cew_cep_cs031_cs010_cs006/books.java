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

    ArrayList<String> new_back_names = new ArrayList<>();
    ArrayList<Integer> new_back_image = new ArrayList<>();
    String prices[] = {"Rs.550","Rs.650","Rs.580","Rs.450","Rs.530","Rs.750","Rs.680","Rs.450",
            "Rs.550","Rs.450","Rs.750","Rs.450","Rs.300"};
    String books_title[] = {"Harry Potter and the Philosopher's Stone",
            "Harry Potter and the Chamber of Secrets",
            "Harry Potter and the Prisoner of Azkaban","Amara the Brave", "The Book of Warlock",
            "Hunger Games : Catching Fire", "The Dreaming Arts", "Heart Spring Mountain",
            "The Hypocrite World", "RED Planet", "SEEDS of HATRED", "Torn", "The Girl on the Train"};
    int book_images[] = {R.drawable.harry1, R.drawable.harry2, R.drawable.harry3,
            R.drawable.amarabrave, R.drawable.bookwarlock, R.drawable.catchingfire,
            R.drawable.dreamingarts, R.drawable.heartspringbook, R.drawable.hypocriteworld,
            R.drawable.redplanet, R.drawable.seedshatred, R.drawable.torn, R.drawable.train};
    double rating[] = {4.5, 4, 3.5, 3, 4.5, 5, 4, 4, 4, 3, 2, 5, 4.5, 3.5, 4};

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        list_page_cart = findViewById(R.id.cart2);
        display_names = findViewById(R.id.display_name);
        recyclerView = findViewById(R.id.recyclerView1);

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


        recycling_books adapter = new recycling_books(this, books_title, book_images, prices, rating);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}