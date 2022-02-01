package com.example.cew_cep_cs031_cs010_cs006;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    private Button register;
    private EditText username;
    private EditText email_signup;
    private EditText password_signup;
    private TextView findinglocation2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        register = findViewById(R.id.register);
        username = findViewById(R.id.username);
        email_signup = findViewById(R.id.email);
        password_signup = findViewById(R.id.password);
        findinglocation2 = findViewById(R.id.location2);
        database signing = new database(signup.this);

        findinglocation2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(signup.this, MapsActivity.class);
                startActivity(i);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                String user1 = username.getText().toString();
                String email1 = email_signup.getText().toString();
                String pass1 = password_signup.getText().toString();
                if(email1.endsWith("@gmail.com" )|| email1.endsWith("@yahoo.com")){
                    if(user1.equals("") || email1.equals("") || pass1.equals("")){
                        Toast.makeText(signup.this, "Fill the fields to Sign Up........", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Cursor checking_row = signing.get_info();
                        while(checking_row.moveToNext()){
                            if(checking_row.getString(2).equals(email1)){
                                Toast.makeText(signup.this, "Account with this Email has already Signed Up ....", Toast.LENGTH_LONG).show();
                                i=1;
                                break;
                            }
                            else if(checking_row.getString(1).equals(user1)){
                                Toast.makeText(signup.this, "Account with this Username has already Signed Up ....", Toast.LENGTH_LONG).show();
                                i=1;
                                break;
                            }
                        }
                        if (i==0){
                            Boolean result = signing.data_insertion_database(user1, email1, pass1);
                            if (result == true){
                                Toast.makeText(signup.this, "Account is Successfully Registered....", Toast.LENGTH_LONG).show();
                                Intent im = new Intent(signup.this, login.class);
                                startActivity(im);
                            }
                            else {
                                Toast.makeText(signup.this, "Account is not Successfully Registered....", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
                else{
                  Toast.makeText(signup.this, "Incorrect Email Format!!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}