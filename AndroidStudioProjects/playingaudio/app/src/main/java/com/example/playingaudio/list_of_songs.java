package com.example.playingaudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

public class list_of_songs extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] downloads;
    ArrayList<File> items4 = new ArrayList<File>();
    private ImageView searches;
    private EditText content;
    ArrayList<Integer> successful_searches = new ArrayList<>();
    recycling_songs adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_songs);
        recyclerView = findViewById(R.id.recycling);
        content = findViewById(R.id.edit);
        searches = findViewById(R.id.search_icon);
        Intent intent3 = getIntent();
        Bundle bundle = intent3.getExtras();
        items4 = (ArrayList) bundle.getParcelableArrayList("song");
        downloads = intent3.getStringArrayExtra("converted");

        adapter = new recycling_songs(list_of_songs.this, downloads, items4);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(list_of_songs.this));
        searches.setOnClickListener(new View.OnClickListener() {
            ArrayList<String> new_songs = new ArrayList<>();
            ArrayList<File> new_full_file_songs = new ArrayList<>();
            String[] filtered;
            @Override
            public void onClick(View v) {
                String data = content.getText().toString().toLowerCase(Locale.ROOT);
                for (int i=0; i<downloads.length; i++){
                    String data2 = downloads[i].toLowerCase(Locale.ROOT);
                    if(data2.contains(data.toLowerCase(Locale.ROOT))){
                        new_full_file_songs.add(items4.get(i));
                        new_songs.add(downloads[i]);
                    }
                }
                filtered = new String[new_songs.size()];
                for (int i=0; i< filtered.length; i++){
                    filtered[i] = new_songs.get(i);
                }
                adapter.filter(list_of_songs.this, filtered, new_full_file_songs);
            }
        });
    }
}