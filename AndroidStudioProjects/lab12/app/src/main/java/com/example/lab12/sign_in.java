package com.example.lab12;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_in extends AppCompatActivity {
    EditText email;
    EditText pass;
    Button Signin;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = findViewById(R.id.em1);
        pass = findViewById(R.id.pw1);
        Signin = findViewById(R.id.sign);

        database logging = new database(sign_in.this);

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String pass1 = pass.getText().toString();
                Cursor row = logging.get_info();

                while(row.moveToNext()){
                    if(row.getString(3).equals(mail) && row.getString(4).equals(pass1)) {
                        Toast.makeText(sign_in.this, "You have been Logged-In....", Toast.LENGTH_LONG).show();
                        i = 1;
                        break;
                    }
                }
                if (i==0){
                    Toast.makeText(sign_in.this, "You have not been Logged-In....", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}