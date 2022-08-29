package com.example.dbms_cs031_cs010_cs006_cs008;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class product_detail extends AppCompatActivity {
    ImageView plus,minus;
    TextView noofitems;
    order_database ordering;
    String rup_tag = "Rs.";
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(ContextCompat.getColor(product_detail.this, R.color.white));


        ImageView product_im = findViewById(R.id.product_image);
        TextView product_model = findViewById(R.id.product_name);
        TextView product_desc = findViewById(R.id.product_description);
        TextView product_price = findViewById(R.id.product_rupee);
        RatingBar product_rate_bar = findViewById(R.id.product_ratingbar);
        relativeLayout = findViewById(R.id.cart_inputting_material);

        ordering = new order_database(product_detail.this);

        Intent intent = getIntent();
        byte[] byteArray = getIntent().getByteArrayExtra("model_image");
        Bitmap item_image = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        String item_name = intent.getStringExtra("model_name");
        float ratingBar = Float.parseFloat(intent.getStringExtra("model_rate"));
        String item_price = rup_tag + intent.getStringExtra("model_price");
        String item_price_calculation = intent.getStringExtra("model_price");
        String model_information = intent.getStringExtra("model_detailed_information");

        product_im.setImageBitmap(item_image);
        product_model.setText(item_name);
        product_desc.setText(model_information);
        product_rate_bar.setRating(ratingBar);
        product_price.setText(item_price);


        /////Functionality to add minus items in cart/////
        plus = (ImageView) findViewById(R.id.plus);
        minus = (ImageView) findViewById(R.id.minus);
        noofitems = (TextView) findViewById(R.id.noofitems);
        final int [] number = {1};
        noofitems.setText(""+number[0]);

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number[0] == 1) {
                    noofitems.setText("" + number[0]);
                }
                if (number[0] > 0) {
                    number[0] = number[0] - 1;
                    noofitems.setText("" + number[0]);
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number[0] == 9) {
                    noofitems.setText("" + number[0]);
                }
                if (number[0] < 9) {
                    number[0] = number[0] + 1;
                    noofitems.setText("" + number[0]);
                }
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bmp = item_image;
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                int total = Integer.parseInt(noofitems.getText().toString())*Integer.parseInt(item_price_calculation);
                String total_price = String.valueOf(total);
                ordering.data_insertion_database(item_name, model_information, String.valueOf(ratingBar),
                        item_price, noofitems.getText().toString(), total_price, byteArray);
                Toast.makeText(product_detail.this, "Item is added to your Cart", Toast.LENGTH_LONG).show();
            }
        });
    }
}