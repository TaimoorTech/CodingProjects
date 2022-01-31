package com.example.cew_cep_cs031_cs010_cs006;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class checkout extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        recyclerView = findViewById(R.id.recycle);

//        Intent get = getIntent();
//        ArrayList<String> n = get.getStringArrayListExtra("names");
//        ArrayList<Integer> im = get.getIntegerArrayListExtra("im");
        ArrayList<String> n = displaying_information.getActivityInstance1().getdata1();
        ArrayList<Integer> im = displaying_information.getActivityInstance2().getdata2();

        recyclingcart adapter = new recyclingcart(this, n, im);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}