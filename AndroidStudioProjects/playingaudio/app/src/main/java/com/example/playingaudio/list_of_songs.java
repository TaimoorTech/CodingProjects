package com.example.playingaudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

public class list_of_songs extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] downloads;
    ArrayList<File> items4 = new ArrayList<File>();
    ImageView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_songs);
        recyclerView = findViewById(R.id.recycling);
        search = findViewById(R.id.searchicon);
        Intent intent3 = getIntent();
        Bundle bundle = intent3.getExtras();
        items4 = (ArrayList) bundle.getParcelableArrayList("song");
        downloads = intent3.getStringArrayExtra("converted");
        recycling_songs adapter = new recycling_songs(this, downloads, items4);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}