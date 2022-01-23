package com.example.cew_cep_cs031_cs010_cs006;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class books extends AppCompatActivity {
    private TextView display_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        display_name = findViewById(R.id.display);
        Intent getName =  getIntent();
        String user = getName.getStringExtra("login_name");
        display_name.setText("Hello " + user);
    }
}