package com.example.lab11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText first_name;
    EditText last_name;
    SharedPreferences sharedPreferences;
    Button retrieve;
    Button save;
    Button get_info;
    public static final String my_preference = "save_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first_name = findViewById(R.id.first);
        last_name = findViewById(R.id.last);
        sharedPreferences = getSharedPreferences(my_preference, 0);
        retrieve = findViewById(R.id.ret);
        save = findViewById(R.id.save);
        get_info = findViewById(R.id.get);
    }

    public void save_data(View view){
        String name1 = first_name.getText().toString();
        String name2 = last_name.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name_first", name1);
        editor.putString("name_last", name2);
        editor.commit();
        Toast.makeText(MainActivity.this, "Data is saved....", Toast.LENGTH_LONG).show();
    }

    public void clear_data(View view){
        first_name.setText("");
        last_name.setText("");
        Toast.makeText(MainActivity.this, "Data is cleared....", Toast.LENGTH_LONG).show();
    }

    public void get_info(View view){
        sharedPreferences = getSharedPreferences(my_preference, 0);
        if (sharedPreferences.contains("name_first")){
            first_name.setText(sharedPreferences.getString("name_first", "abc"));
        }
        if (sharedPreferences.contains("name_last")){
            first_name.setText(sharedPreferences.getString("name_last", "abcd"));
        }
    }
}