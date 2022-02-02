package com.example.lab12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_up extends AppCompatActivity {
    EditText first;
    EditText last;
    EditText email;
    EditText pass;
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        first = findViewById(R.id.first);
        last = findViewById(R.id.last);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        ok = findViewById(R.id.ok);
        database signing = new database(Sign_up.this);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = first.getText().toString();
                String name2 = last.getText().toString();
                String em = email.getText().toString();
                String pw = pass.getText().toString();

                Boolean result = signing.data_insertion_database(name1, name2, em, pw);
                if (result == true){
                    Toast.makeText(Sign_up.this, "Account is Successfully Registered....", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Sign_up.this, "Account is not Successfully Registered....", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}