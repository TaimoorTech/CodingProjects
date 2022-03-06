package com.example.tablayout_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabItem;

public class MainActivity extends AppCompatActivity {

    TableLayout tableLayout;
    TabItem taimoor;
    TabItem hussain;
    TabItem arif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Accessing IDs
        tableLayout = findViewById(R.id.tab_layout);
        taimoor = findViewById(R.id.tab1);
        hussain = findViewById(R.id.tab2);
        arif = findViewById(R.id.tab3);


    }
}