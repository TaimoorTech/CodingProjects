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

public class books extends AppCompatActivity {
    ImageView list_page_cart;
    RecyclerView recyclerView;
    TextView display_names;
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
}