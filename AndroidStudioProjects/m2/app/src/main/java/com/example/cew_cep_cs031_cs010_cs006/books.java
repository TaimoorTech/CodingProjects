package com.example.cew_cep_cs031_cs010_cs006;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class books extends AppCompatActivity {
    int j= 0;
    Button button;
    RecyclerView recyclerView;
    //TextView display_name;
    String books_title[] = {"Harry Potter and the Philosopher's Stone",
            "Harry Potter and the Chamber of Secrets",
            "Harry Potter and the Prisoner of Azkaban"};
    int book_images[] = {R.drawable.harry1, R.drawable.harry2, R.drawable.harry3};
    ArrayList<String> b = new ArrayList<>();
    ArrayList<Integer> i = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        //display_name = findViewById(R.id.display);
        recyclerView = findViewById(R.id.recyclerView1);
        button = findViewById(R.id.button);

//        Intent getName =  getIntent();
//        String user = getName.getStringExtra("login_name");
//        display_name.setText("Welcome " + user);

        //books_title = getResources().getStringArray(R.array.Book_Name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(books.this, MainActivity2.class);
                b.add(books_title[j]);
                i.add(book_images[j]);
                j++;
                intent.putStringArrayListExtra("namess", b);
                intent.putIntegerArrayListExtra("imgs", i);
                startActivity(intent);
            }
        });
       recycling_books adapter = new recycling_books(this, books_title, book_images);
       recyclerView.setAdapter(adapter);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}