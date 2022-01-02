package com.example.cew_lab_6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class design_listview extends ArrayAdapter<String> {
    String[] items_list;

    public design_listview(@NonNull Context context, int resource, @NonNull String[] items_list) {
        super(context, resource, items_list);
        this.items_list = items_list;
    }
    @Nullable
    @Override
    public String getItem(int position){
        return items_list[position];
    }

    @NonNull
    @Override
    public View getView(int position,@Nullable View convertView, @Nullable ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_design_listview,
                parent, false);
        TextView t = convertView.findViewById(R.id.textView);
        t.setText(getItem(position));
        return convertView;
    }
}