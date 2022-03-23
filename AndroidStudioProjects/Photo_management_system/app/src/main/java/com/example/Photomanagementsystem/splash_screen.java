package com.example.Photomanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splash_screen extends AppCompatActivity {

    Animation animation;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        name = findViewById(R.id.app_name);

        animation = AnimationUtils.loadAnimation(this, R.anim.anim);

        name.startAnimation(animation);

        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent =  new Intent(splash_screen.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };thread.start();
    }
}