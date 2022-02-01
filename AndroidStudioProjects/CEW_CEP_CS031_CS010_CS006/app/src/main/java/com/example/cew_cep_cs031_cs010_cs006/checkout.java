package com.example.cew_cep_cs031_cs010_cs006;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class checkout extends AppCompatActivity {
    RecyclerView recyclerView;
    Button checkingOut;
    EditText address;
    TextView findinglocation6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        findinglocation6 = findViewById(R.id.loc6);
        recyclerView = findViewById(R.id.recycle);
        checkingOut = findViewById(R.id.checkoutting);
        address = findViewById(R.id.address);

        findinglocation6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(checkout.this, MapsActivity.class);
                startActivity(i);
            }
        });

        checkingOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                String name = i.getStringExtra("n2");
                if (name.equals("")){
                    Toast.makeText(checkout.this, "Kindly Login_first to checkout", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(checkout.this, login.class);
                    startActivity(intent);
                }
                else{
                    if(address.getText().toString().equals("")){
                        address.setError("Kindly Enter Address");
                    }
                    else {
                        Toast.makeText(checkout.this, "Your Order has been placed on address\n"
                                +address.getText().toString(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        Intent get = getIntent();
        ArrayList<String> n = get.getStringArrayListExtra("names");
        ArrayList<Integer> im = get.getIntegerArrayListExtra("im");
        ArrayList<String> f = get.getStringArrayListExtra("rat");

        recyclingcart adapter = new recyclingcart(this, n, im, f);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}