package com.example.cew_lab_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {"FLOUR", "RICE", "CANOLA OIL", "BREAD", "SUGAR"};
        String[] prices = {"Rs.400 Per Kg", "Rs.300 Per Kg", "Rs.450 (3 Litre Bottle)", "Rs.70",
                "Rs.240 Per Kg"};
        listView = findViewById(R.id.list);
        design_listview items_list = new design_listview(this,
                R.layout.activity_design_listview, items);
        listView.setAdapter(items_list);
        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(listView, "Price : \n" + items[position] + " is " +
                        prices[position] + ".", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, view, menuInfo);
        getMenuInflater().inflate(R.menu.menus, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.edit:
                Toast.makeText(MainActivity.this, "Edit option selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.share:
                Toast.makeText(MainActivity.this, "Share option selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.del:
                Toast.makeText(MainActivity.this, "Delete option selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(menuItem); }
    }
}