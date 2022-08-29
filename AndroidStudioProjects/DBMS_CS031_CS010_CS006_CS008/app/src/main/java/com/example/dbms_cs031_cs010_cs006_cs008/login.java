package com.example.dbms_cs031_cs010_cs006_cs008;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class login extends AppCompatActivity {
    TextInputEditText textInputEditText2, textInputEditText3;
    Button btnlogin;
    TextView signuptext;
    ProgressBar progressBar;

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(login.this,signup.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(ContextCompat.getColor(login.this, R.color.white));

        textInputEditText2 = findViewById(R.id.textInputEditText2);
        textInputEditText3 = findViewById(R.id.textInputEditText3);
        btnlogin = findViewById(R.id.btnlogin);
        signuptext = findViewById(R.id.signuptext);
        progressBar = findViewById(R.id.progress);
        signuptext.setOnClickListener(v -> {
            Intent intent=new Intent(login.this,signup.class);
            startActivity(intent);
            finish();
        });
        btnlogin.setOnClickListener(v -> {
            String username,password;
            username= String.valueOf(textInputEditText2.getText());
            password= String.valueOf(textInputEditText3.getText());
            //Starting Write and Read data with URL
            //Creating array for parameters
            String[] field = new String[2];
            //Start ProgressBar first (Set visibility VISIBLE)
            if (!username.equals("")&&!password.equals("")) {
                progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.post(() -> {
                    field[0] = "username";
                    field[1] = "password";
                    //Creating array for data
                    String[] data = new String[2];
                    data[0] = username;
                    data[1] = password;
                    PutData putData = new PutData("http://192.168.2.4:/loginregister/login.php", "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            progressBar.setVisibility(View.GONE);
                            String result = putData.getResult();
                            if (result.equals("Login Success")) {
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(login.this,MainActivity.class );
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(login.this, "Invalid username or password...", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
            else
                Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
        });
    }
}