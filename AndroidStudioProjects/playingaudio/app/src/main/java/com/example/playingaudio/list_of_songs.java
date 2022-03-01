package com.example.playingaudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class list_of_songs extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] downloads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_songs);
        recyclerView = findViewById(R.id.recycling);
        Intent intent3 = getIntent();
        downloads = intent3.getStringArrayExtra("converted");

        recycling_songs adapter = new recycling_songs(this, downloads);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}