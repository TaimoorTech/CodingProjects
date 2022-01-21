package com.example.cew_cep_cs031_cs010_cs006;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    private Button register;
    private EditText username;
    private EditText email_signup;
    private EditText password_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        register = findViewById(R.id.register);
        username = findViewById(R.id.username);
        email_signup = findViewById(R.id.email);
        password_signup = findViewById(R.id.password);
        database creating = new database(signup.this);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user1 = username.getText().toString();
                String email1 = email_signup.getText().toString();
                String pass1 = password_signup.getText().toString();
                if(user1.equals("") || email1.equals("") || pass1.equals("")){
                    Toast.makeText(signup.this, "Fill the fields to Sign Up........", Toast.LENGTH_LONG).show();
                }
                else{
                    Boolean result = creating.data_insertion_database(user1, email1, pass1);
                    if (result == true){
                        Toast.makeText(signup.this, "Account is Successfully Registered....", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(signup.this, "Account is not Successfully Registered....", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}