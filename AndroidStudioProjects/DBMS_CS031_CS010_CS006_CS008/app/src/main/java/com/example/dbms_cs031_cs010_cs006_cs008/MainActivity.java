package com.example.dbms_cs031_cs010_cs006_cs008;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.white));

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        ImageView three_bar_line = findViewById(R.id.three_bar_line);
        ImageView cart_show = findViewById(R.id.first_cart_activity);

        cart_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,
                        activity_cart_list.class);
                startActivity(i);            }
        });

        three_bar_line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        replaceFragment(new HomeFragment());
        navigationView.setCheckedItem(R.id.home);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id =  item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);

                switch (id) {
                    case R.id.home:
                        replaceFragment(new HomeFragment());
                        break;
                    case R.id.tv:
                        replaceFragment(new tvFragment());
                        break;
                    case R.id.keyboard:
                        replaceFragment(new Keyboard_Fragment());
                        break;
                    case R.id.mouse:
                        replaceFragment(new MouseFragment());
                        break;
                    case R.id.about_us:
                        replaceFragment(new AboutUsFragment());
                        break;
                }
                return true;
            }
        });
    }



    public void replaceFragment(Fragment fragment1){
        Fragment fragment = fragment1;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment).addToBackStack(null).commit();

    }
}