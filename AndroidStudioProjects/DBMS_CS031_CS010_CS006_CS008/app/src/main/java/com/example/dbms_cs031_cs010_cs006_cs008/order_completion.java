package com.example.dbms_cs031_cs010_cs006_cs008;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class order_completion extends AppCompatActivity {
    ArrayList<Bitmap> images_arrayList = new ArrayList<>();
    ArrayList<String> names_arrayList = new ArrayList<>();
    ArrayList<String> prices_arrayList = new ArrayList<>();
    ArrayList<Float> rate_arrayList = new ArrayList<>();
    ArrayList<String> quantity_arrayList = new ArrayList<>();
    int email_check=0;
    int cart_check=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_completion);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(ContextCompat.getColor(order_completion.this, R.color.white));

        EditText email_given = findViewById(R.id.last_email_edit);
        EditText name_given = findViewById(R.id.last_name_edit);
        EditText address_given = findViewById(R.id.last_address_edit);


        Button button = findViewById(R.id.confirm_order);
        ImageView last_cart = findViewById(R.id.last_carts_act);
        ImageView first_dot = findViewById(R.id.first_dot);
        ImageView second_dot = findViewById(R.id.second_dot);
        ImageView third_dot = findViewById(R.id.third_dot);
        ImageView begin_line = findViewById(R.id.begin_line);
        ImageView begin_line1 = findViewById(R.id.begin_line1);
        ImageView end_line = findViewById(R.id.end_line);
        ImageView end_line1 = findViewById(R.id.end_line1);

        order_database getting = new order_database(order_completion.this);
        Cursor row = getting.get_info();
        while (row.moveToNext()) {
            names_arrayList.add(row.getString(1));
            rate_arrayList.add(Float.valueOf(row.getString(3)));
            prices_arrayList.add(row.getString(6));
            quantity_arrayList.add(row.getString(5));
            byte[] img = row.getBlob(7);
            Bitmap item_image = BitmapFactory.decodeByteArray(img, 0, img.length);
            images_arrayList.add(item_image);
        }
        getting.close();


        last_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (names_arrayList.isEmpty()) {
                    Toast.makeText(order_completion.this, "Cart is Empty...", Toast.LENGTH_LONG).show();
                } else {
                    bottom_sheet_dialog bottom_sheet = new bottom_sheet_dialog();
                    bottom_sheet.show(getSupportFragmentManager(), bottom_sheet.getTag());
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sender_email_address = "worldofelectronics407@gmail.com";
                String sender_email_password = "kytyfhwfdljumjrf";
                String receiver_email_address = email_given.getText().toString();
                String receiver_name = name_given.getText().toString();
                String receiver_address = address_given.getText().toString();

                if (receiver_name.isEmpty() || receiver_email_address.isEmpty() || receiver_address.isEmpty()){
                    Toast.makeText(order_completion.this, "Fill out all name and email fields and address field...", Toast.LENGTH_LONG).show();
                }
                else if (names_arrayList.size()>0){
                    if (Patterns.EMAIL_ADDRESS.matcher(receiver_email_address).matches()){
                        try {

                            String stringHost = "smtp.gmail.com";

                            Properties properties = System.getProperties();
                            properties.put("mail.smtp.host", stringHost);
                            properties.put("mail.smtp.port", "465");
                            properties.put("mail.smtp.ssl.enable", "true");
                            properties.put("mail.smtp.auth", "true");

                            javax.mail.Session session = Session.getInstance(properties, new Authenticator() {
                                @Override
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(sender_email_address, sender_email_password);
                                }
                            });

                            MimeMessage mimeMessage = new MimeMessage(session);
                            String data = "";
                            int total_count=0;
                            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver_email_address));
                            for(int i=0; i<names_arrayList.size(); i++){
                                data = data + "Product: "+names_arrayList.get(i)+","+"Quantity: "+ quantity_arrayList.get(i)+","+"Total Price :"+
                                        prices_arrayList.get(i)+","+"\n";
                                total_count = total_count+Integer.parseInt(prices_arrayList.get(i));
                            }
                            mimeMessage.setSubject("Your Order:");
                            mimeMessage.setText("Hi! "+receiver_name+"\n"+"Order: "+"\n"+data+"\n"+
                                    "Total: " + total_count+"\n"+"Order is placed at: "+receiver_address);



                            MimeMessage mimeMessage1 = new MimeMessage(session);
                            mimeMessage1.addRecipient(Message.RecipientType.TO, new InternetAddress("worldofelectronics407@gmail.com"));
                            mimeMessage1.setSubject("New Order:");
                            mimeMessage1.setText("By "+receiver_name+" and "+receiver_email_address+"\n" +"Order: "+"\n"+data+"\n"+
                                    "Total: " + total_count+"\n"+"Order is placed at: "+receiver_address);

                            Thread thread2 = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Transport.send(mimeMessage);
                                        Transport.send(mimeMessage1);
                                    } catch (MessagingException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });thread2.start();
                        } catch (AddressException e) {
                            e.printStackTrace();
                        } catch (MessagingException e) {
                            e.printStackTrace();
                        }

                        Thread thread = new Thread(){
                            public void run(){
                                try{
                                    sleep(5000);
                                    first_dot.setImageResource(R.drawable.ic_baseline_circle_24);
                                    begin_line.setImageResource(R.drawable.green_vertical_line);
                                    begin_line1.setImageResource(R.drawable.green_vertical_line);
                                    sleep(5000);
                                    second_dot.setImageResource(R.drawable.ic_baseline_circle_24);
                                    end_line.setImageResource(R.drawable.green_vertical_line);
                                    end_line1.setImageResource(R.drawable.green_vertical_line);
                                    sleep(5000);
                                    third_dot.setImageResource(R.drawable.ic_baseline_circle_24);
                                }
                                catch(Exception e){
                                    e.printStackTrace();
                                }
                                finally{
                                }
                            }
                        };thread.start();
//                    email_ordered_database emailOrderedDatabase = new email_ordered_database(order_completion.this);
//                    emailOrderedDatabase.data_insertion_database(names_arrayList, rate_arrayList,
//                            quantity_arrayList, prices_arrayList);

//                    order_database del = new order_database(order_completion.this);
//                        names_arrayList.clear();
//                        quantity_arrayList.clear();
//                        prices_arrayList.clear();
//                        images_arrayList.clear();
//                        rate_arrayList.clear();
//                        del.deleteAllData();
                        String[] field = new String[8];
                        Handler handler = new Handler();
                        handler.post(()->{
                            field[0] = "date";
                            field[1] = "time";
                            field[2] = "email";
                            field[3] = "name";
                            field[4] = "address";
                            field[5] = "model_name";
                            field[6] = "quantity";
                            field[7] = "total_price";

                            for (int i=0; i<names_arrayList.size(); i++){
                                String[] data = new String[8];
                                data[0] = new SimpleDateFormat("dd/LLL/yyyy", Locale.getDefault()).format(new Date()).toString();
                                data[1] = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date()).toString();
                                if (i==0){
                                    data[2] = receiver_email_address;
                                }
                                else{
                                    data[2] = "*" + receiver_email_address;
                                }
                                data[3] = receiver_name;
                                data[4] = receiver_address;
                                data[5] = names_arrayList.get(i);
                                data[6] = quantity_arrayList.get(i);
                                data[7] = prices_arrayList.get(i);

                                PutData putData = new PutData("http://192.168.2.4:/order_information_db/order.php", "POST", field, data);
                                if (putData.startPut()) {
                                    if (putData.onComplete()) {
                                        String result = putData.getResult();
                                        if (result.equals("Order Placed Successfully")) {
                                            Toast.makeText(getApplicationContext(), "Order Placed Successfully to Store", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Order Placing Operation Unsuccessful", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }

                            order_database del = new order_database(order_completion.this);
                            names_arrayList.clear();
                            quantity_arrayList.clear();
                            prices_arrayList.clear();
                            images_arrayList.clear();
                            rate_arrayList.clear();
                            del.deleteAllData();
                        });
                    }
                    else {
                        Toast.makeText(order_completion.this, "Email Pattern is Wrong...",
                                Toast.LENGTH_LONG) .show();
                    }
                }
                else {
                    Toast.makeText(order_completion.this, "Cart is Empty, cannot place order", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}