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
    String[] main_downloads;
    ArrayList<File> main_songs = new ArrayList<File>();
    private ImageView searches;
    private EditText content;
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
        main_songs = (ArrayList) bundle.getParcelableArrayList("song");
        main_downloads = intent3.getStringArrayExtra("converted");
        adapter = new recycling_songs(list_of_songs.this, main_downloads, main_songs, main_downloads, main_songs);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(list_of_songs.this));
        searches.setOnClickListener(new View.OnClickListener() {
            ArrayList<String> new_songs = new ArrayList<>();
            ArrayList<File> new_full_file_songs = new ArrayList<>();
            String[] filtered;
            @Override
            public void onClick(View v) {
                new_songs.clear();
                new_full_file_songs.clear();
                filtered = null;
                String data = content.getText().toString().toLowerCase(Locale.ROOT);
                if (data.isEmpty()){
                    adapter.filter(list_of_songs.this, main_downloads, main_songs);
                }
                else {
                    for (int i=0; i<main_downloads.length; i++){
                        String data2 = main_downloads[i].toLowerCase(Locale.ROOT);
                        if(data2.contains(data.toLowerCase(Locale.ROOT))){
                            new_full_file_songs.add(main_songs.get(i));
                            new_songs.add(main_downloads[i]);
                        }
                    }
                    filtered = new String[new_songs.size()];
                    for (int i=0; i< filtered.length; i++){
                        filtered[i] = new_songs.get(i);
                    }
                    adapter.filter(list_of_songs.this, filtered, new_full_file_songs);
                }

            }
        });
    }
}