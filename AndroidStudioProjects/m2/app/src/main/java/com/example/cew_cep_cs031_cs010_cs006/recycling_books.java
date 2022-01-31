package com.example.cew_cep_cs031_cs010_cs006;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recycling_books extends RecyclerView.Adapter<recycling_books.MyViewHolder> {
    String title[];
    Context context;
    int[] images;

    public recycling_books(Context c, String[] names, int[] image){
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
        holder.titles.setText(title[position]);
        holder.img.setImageResource((Integer) images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
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
