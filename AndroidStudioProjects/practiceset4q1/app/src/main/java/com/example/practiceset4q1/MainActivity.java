package com.example.practiceset4q1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private Button names;
   private Button ids;
   private EditText info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = findViewById(R.id.name);
        ids = findViewById(R.id.id);
        info = findViewById(R.id.editTextTextPersonName);
        names.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if(info.getText().toString().length()>0) {
                    Toast.makeText(MainActivity.this, "Name is : " + info.getText().toString(), Toast.LENGTH_LONG)
                            .show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Kindly Enter Data in Text" + info.getText().toString(), Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
        ids.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if(info.getText().toString().length()>0) {
                    Toast.makeText(MainActivity.this, "ID is : " + info.getText().toString(), Toast.LENGTH_LONG)
                            .show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Kindly Enter Data in Text" + info.getText().toString(), Toast.LENGTH_LONG)
                            .show();
                }            }
        });
    }
}