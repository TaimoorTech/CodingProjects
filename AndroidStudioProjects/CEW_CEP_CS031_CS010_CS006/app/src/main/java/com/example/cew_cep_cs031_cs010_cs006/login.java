package com.example.cew_cep_cs031_cs010_cs006;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private Button login;
    private EditText email_login;
    private EditText password_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.loging);
        email_login = findViewById(R.id.email_login);
        password_login = findViewById(R.id.password_login);
        database logging = new database(login.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email_login.getText().toString();
                String pass = password_login.getText().toString();
                Cursor row = logging.get_info();
                int i = 0;
                if(mail.equals("") || pass.equals("")){
                    Toast.makeText(login.this, "Fill the fields to Logged In........", Toast.LENGTH_LONG).show();
                }
                else{
                    while(row.moveToNext()){
                        if(row.getString(2).equals(mail) && row.getString(3).equals(pass)){
                            Toast.makeText(login.this, "You have been Logged-In....", Toast.LENGTH_LONG).show();
                            i=1;
                            break;
                        }
                    }
                    if(i==0) {
                        Toast.makeText(login.this, "No data found....", Toast.LENGTH_LONG).show();
                    }
                    else{
                        String name = row.getString(1);
                        Intent intent2 = new Intent(login.this, books.class);
                        intent2.putExtra("login_name", name);
                        startActivity(intent2);
                    }
                }
            }
        });
    }
}