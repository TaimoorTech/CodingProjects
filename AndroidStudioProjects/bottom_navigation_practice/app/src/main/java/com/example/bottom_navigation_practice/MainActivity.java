package com.example.bottom_navigation_practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.b_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new home()).commit();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment temp = null;

                switch (item.getItemId()){

                    case R.id.home:
                        temp = new home();
                        break;
                    case R.id.call:
                        temp = new call();
                        break;
                    case R.id.Setting:
                        temp = new setting();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame, temp).commit();

                return true;
            }
        });
    }
}