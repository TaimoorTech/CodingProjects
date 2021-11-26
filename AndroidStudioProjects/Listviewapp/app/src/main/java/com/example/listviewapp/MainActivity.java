package com.example.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] arr =  {"Harry", "taimoor", "hussain", "Harry", "taimoor", "hussain",
            "Harry", "taimoor", "hussain", "Harry", "taimoor", "hussain"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
//        ArrayAdapter ad = new ArrayAdapter(this, R.layout.my_listview, arr);
//        listView.setAdapter(ad);
        my_list_view m = new my_list_view(this, R.layout.my_listview, arr);
        listView.setAdapter(m);
    }
}