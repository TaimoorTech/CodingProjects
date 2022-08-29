package com.example.dbms_cs031_cs010_cs006_cs008;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class signup extends AppCompatActivity {
    TextInputEditText textInputEditText6,textInputEditText2, textInputEditText3, textInputEditText4;
    Button btnsignup;
    TextView logintext;
    ProgressBar progressBar;

    @Override
    public void onBackPressed() {
        finishAffinity();
        finish();
        System.exit(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(ContextCompat.getColor(signup.this, R.color.white));


        textInputEditText6 = findViewById(R.id.textInputEditText6);
        textInputEditText2 = findViewById(R.id.textInputEditText2);
        textInputEditText3 = findViewById(R.id.textInputEditText3);
        textInputEditText4 = findViewById(R.id.textInputEditText4);
        btnsignup = findViewById(R.id.btnsignup);
        logintext = findViewById(R.id.logintext);
        progressBar = findViewById(R.id.progress);
        logintext.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),login.class);
            startActivity(intent);
            finish();
        });

        btnsignup.setOnClickListener(v -> {
            String fullname,username,password,email;
            fullname= String.valueOf(textInputEditText6.getText());
            username= String.valueOf(textInputEditText2.getText());
            password= String.valueOf(textInputEditText3.getText());
            email= String.valueOf(textInputEditText4.getText());
            //Starting Write and Read data with URL
            //Creating array for parameters
            String[] field = new String[4];
            //Start ProgressBar first (Set visibility VISIBLE)
            if (!fullname.equals("") && !username.equals("") && !password.equals("")&&!email.isEmpty()&& Patterns.EMAIL_ADDRESS.matcher(email).matches()){

                progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.post(() -> {
                    field[0] = "fullname";
                    field[1] = "username";
                    field[2] = "password";
                    field[3] = "email";
                    //Creating array for data
                    String[] data = new String[4];
                    data[0] = fullname;
                    data[1] = username;
                    data[2] = password;
                    data[3] = email;
                    PutData putData = new PutData("http://192.168.2.4:/loginregister/signup.php", "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            progressBar.setVisibility(View.GONE);
                            String result = putData.getResult();
                            if (result.equals("Sign Up Success")) {
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),login.class );
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Username or Email has " +
                                        "been already registered.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
            else
                Toast.makeText(getApplicationContext(), "Invalid credentials ", Toast.LENGTH_SHORT).show();
        });

    }
}
