package com.example.dbms_cs031_cs010_cs006_cs008;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class cart_last_screen_recycler extends RecyclerView.Adapter<cart_last_screen_recycler.viewholder>{
    ArrayList<Bitmap> images_arrayList = new ArrayList<>();
    ArrayList<String> names_arrayList = new ArrayList<>();
    ArrayList<String> prices_arrayList = new ArrayList<>();
    ArrayList<Float> rate_arrayList = new ArrayList<>();
    ArrayList<String> quantity_arrayList = new ArrayList<>();
    Context context;


    public cart_last_screen_recycler(Context c, ArrayList<String> model, ArrayList<Bitmap> img_item,
                                     ArrayList<Float> rating, ArrayList<String> total_price,
                                     ArrayList<String> quantity){
        images_arrayList = img_item;
        context=c;
        names_arrayList = model;
        rate_arrayList = rating;
        quantity_arrayList = quantity;
        prices_arrayList = total_price;
    }

    public void filter(Context c, ArrayList<String> model, ArrayList<Bitmap> img_item,
                       ArrayList<Float> rating, ArrayList<String> total_price,
                       ArrayList<String> quantity){
        images_arrayList = img_item;
        context=c;
        names_arrayList = model;
        rate_arrayList = rating;
        quantity_arrayList = quantity;
        prices_arrayList = total_price;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public cart_last_screen_recycler.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =  inflater.inflate(R.layout.cart_last_screen_design, parent, false);
        return new cart_last_screen_recycler.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cart_last_screen_recycler.viewholder holder, int position) {
        String rupee_tag = "Rs.";
        holder.cart_image_item.setImageBitmap(images_arrayList.get(position));
        holder.cart_name_item.setText(names_arrayList.get(position));
        holder.cart_quantity_item.setText(quantity_arrayList.get(position));
        holder.cart_price_item.setText(rupee_tag.concat(prices_arrayList.get(position)));
        holder.cart_rate_item.setRating(rate_arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return names_arrayList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView cart_image_item;
        TextView cart_name_item;
        TextView cart_price_item;
        TextView cart_quantity_item;
        RatingBar cart_rate_item;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            cart_image_item = itemView.findViewById(R.id.last_item_img);
            cart_name_item = itemView.findViewById(R.id.last_product_name);
            cart_price_item = itemView.findViewById(R.id.last_price_num);
            cart_quantity_item = itemView.findViewById(R.id.last_quantity_num);
            cart_rate_item = itemView.findViewById(R.id.last_ratingbar);
        }
    }
}
