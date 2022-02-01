package com.example.cew_cep_cs031_cs010_cs006;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button signup_button;
    private Button login_button;
    private TextView direct_logging;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database creating = new database(MainActivity.this);
        SQLiteDatabase database = creating.getReadableDatabase();

        signup_button = findViewById(R.id.signup_main);
        login_button = findViewById(R.id.login_main);
        direct_logging = findViewById(R.id.direct);

        direct_logging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent going = new Intent(MainActivity.this, books.class);
                going.putExtra("login_name", " ");
                startActivity(going);
            }
        });

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, signup.class);
                startActivity(intent);
            }
        });
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
            }
        });
    }
}