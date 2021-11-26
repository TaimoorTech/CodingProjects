package com.example.additionandmultipkication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button display;
    private EditText text1;
    private EditText text2;
    private TextView text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.editTextNumber);
        text2 = findViewById(R.id.editTextNumber2);
        text3 = findViewById(R.id.textView4);
        display = findViewById(R.id.button);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = text1.getText().toString();
                String num2 = text2.getText().toString();
                double result = Double.parseDouble(num1) + Double.parseDouble(num2);
                text3.setText("         Sum : " + result);
            }
        });
    }
}