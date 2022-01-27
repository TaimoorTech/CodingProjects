package com.example.cew_cep_cs031_cs010_cs006;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class displaying_information extends AppCompatActivity {
    TextView information;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaying_information);

        information = findViewById(R.id.information);
        img = findViewById(R.id.retrieve_image);

        Intent retrieving = getIntent();
        String info = retrieving.getStringExtra("information");
        int put_image = retrieving.getIntExtra("image_resource",1);

        information.setText(info);
        img.setImageResource(put_image);

    }
}