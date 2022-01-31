package com.example.cew_cep_cs031_cs010_cs006;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rrr extends RecyclerView.Adapter<rrr.MyViewHolder> {
    ArrayList<String> title = new ArrayList<>();
    Context context;
    ArrayList<Integer> images = new ArrayList<>();;

    public rrr(Context c, ArrayList<String> names, ArrayList<Integer> image){
        context = c;
        title = names;
        images = image;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View setting_view = inflater.inflate(R.layout.designing_books_view, parent, false);
        return new MyViewHolder(setting_view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titles.setText(title.get(position));
        holder.img.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titles;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titles = itemView.findViewById(R.id.titleOfBook);
            img = itemView.findViewById(R.id.images_book);
        }
    }
}
