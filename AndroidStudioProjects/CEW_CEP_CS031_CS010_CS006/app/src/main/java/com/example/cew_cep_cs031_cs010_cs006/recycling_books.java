package com.example.cew_cep_cs031_cs010_cs006;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

public class recycling_books extends RecyclerView.Adapter<recycling_books.MyViewHolder> {
    String title[];
    Context context;
    int images[];
    String prices[];
    double ratings[];
    String login_names;


    public recycling_books(Context c, String names[], int []image, String []price, double []rating, String name){
        context = c;
        title = names;
        images = image;
        prices = price;
        ratings = rating;
        login_names = name;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View setting_view = inflater.inflate(R.layout.designing_books_view, parent, false);
        return new MyViewHolder(setting_view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.titles.setText(title[position]);
        holder.img.setImageResource(images[position]);
        holder.rupee.setText(prices[position]);
        holder.ratingBar.setRating((float) ratings[position]);
        holder.mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(context, displaying_information.class);
                intent3.putExtra("title", title[position]);
                intent3.putExtra("image_resource", images[position]);
                intent3.putExtra("rating", String.valueOf(ratings[position]));
                intent3.putExtra("num", position);
                intent3.putExtra("n1", login_names);
                context.startActivity(intent3);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RatingBar ratingBar;
        TextView rupee;
        TextView titles;
        ImageView img;
        TextView description;
        ConstraintLayout mainlayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titles = itemView.findViewById(R.id.titleOfBook);
            ratingBar = itemView.findViewById(R.id.ratingbar);
            img = itemView.findViewById(R.id.images_book);
            mainlayout = itemView.findViewById(R.id.mainlayout);
            rupee = itemView.findViewById(R.id.money);
        }
    }
}
