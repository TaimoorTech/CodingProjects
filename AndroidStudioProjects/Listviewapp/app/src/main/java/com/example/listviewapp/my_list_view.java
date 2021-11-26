package com.example.listviewapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class my_list_view extends ArrayAdapter<String>{
    String []arr;

    public my_list_view(@NonNull Context context, int resource, @NonNull String[] arr) {
        super(context, resource, arr);
        this.arr = arr;
    }


    @Nullable
    @Override
    public String getItem(int position){
        return arr[position];
    }

    @NonNull
    @Override
    public View getView(int position,@Nullable View convertView, @Nullable ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_listview, parent, false);
        TextView t = convertView.findViewById(R.id.textView);
        t.setText(getItem(position));
        return convertView;
    }

}
