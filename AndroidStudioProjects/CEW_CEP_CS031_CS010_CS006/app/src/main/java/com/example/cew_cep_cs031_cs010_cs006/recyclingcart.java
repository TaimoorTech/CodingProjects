package com.example.cew_cep_cs031_cs010_cs006;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclingcart extends RecyclerView.Adapter<recyclingcart.MyViewHolder> {
    ArrayList<String> naming  = new ArrayList<>();
    ArrayList<Integer> imaging  = new ArrayList<>();
    ArrayList<String> ratings = new ArrayList<>();
    Context context;

    public recyclingcart(Context c, ArrayList<String> s, ArrayList<Integer> i, ArrayList<String> r){
        context = c;
        naming = s;
        imaging = i;
        ratings = r;
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
        holder.titles.setText(naming.get(position));
        holder.img.setImageResource(imaging.get(position));
        holder.ratingBar.setRating(Float.parseFloat(ratings.get(position)));
//        holder.mainlayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                String[] getting_information = contents.get_description();
//
//                Intent intent3 = new Intent(context, displaying_information.class);
//                intent3.putExtra("title", title[position]);
//                intent3.putExtra("image_resource", images[position]);
//                intent3.putExtra("num", position);
//                context.startActivity(intent3);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return imaging.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RatingBar ratingBar;
        TextView titles;
        ImageView img;
//        ConstraintLayout mainlayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titles = itemView.findViewById(R.id.titleOfBook);
            img = itemView.findViewById(R.id.images_book);
            ratingBar = itemView.findViewById(R.id.ratingbar);
//            mainlayout = itemView.findViewById(R.id.mainlayout);
        }
    }
}

