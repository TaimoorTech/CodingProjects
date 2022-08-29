package com.example.dbms_cs031_cs010_cs006_cs008;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splash_screen extends AppCompatActivity {

    Animation animation;
    TextView app_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(ContextCompat.getColor(splash_screen.this, R.color.white));

        app_name = findViewById(R.id.app_name);
        animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        app_name.startAnimation(animation);

        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally{
                    Intent intent =  new Intent(splash_screen.this, signup.class);
                    startActivity(intent);
                }
            }
        };thread.start();
    }
}