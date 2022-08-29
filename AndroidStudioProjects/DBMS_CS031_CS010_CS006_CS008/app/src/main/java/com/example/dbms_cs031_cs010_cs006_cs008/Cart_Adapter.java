package com.example.dbms_cs031_cs010_cs006_cs008;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Cart_Adapter extends RecyclerView.Adapter<Cart_Adapter.CartViewHolder> {
    ArrayList<Bitmap> images_arrayList = new ArrayList<>();
    ArrayList<String> names_arrayList = new ArrayList<>();
    ArrayList<String> prices_arrayList = new ArrayList<>();
    ArrayList<Float> rates = new ArrayList<>();
    ArrayList<String> quantity_arrayList = new ArrayList<>();
    //order_database ordering;
    Context context;
    TextView total_count;
    TextView full_total;
    TextView empty_cart;

    public Cart_Adapter(Context c, ArrayList<String> model, ArrayList<Bitmap> img_item,
                        ArrayList<Float> rating, ArrayList<String> price,
                         ArrayList<String> quantity, TextView count, TextView full_t, TextView empty) {
        context = c;
        images_arrayList = img_item;
        total_count = count;
        names_arrayList = model;
        rates = rating;
        prices_arrayList = price;
        full_total = full_t;
        empty_cart = empty;
        quantity_arrayList = quantity;
    }

    @NonNull
    @Override

    public Cart_Adapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =  inflater.inflate(R.layout.viewholder_cart, parent, false);
        return new CartViewHolder(view);
    }

    public void filter(Context c,ArrayList<Bitmap> img_item, ArrayList<String> model,
                       ArrayList<Float> rating, ArrayList<String> price,
                        ArrayList<String> quantity, TextView count,TextView full_t, TextView empty){
        context = c;
        names_arrayList = model;
        images_arrayList = img_item;
        rates = rating;
        prices_arrayList = price;
        quantity_arrayList = quantity;
        total_count = count;
        full_total = full_t;
        empty_cart = empty;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        String rup_tag = "Rs.";
        holder.item_image.setImageBitmap(images_arrayList.get(position));
        holder.item_name.setText(names_arrayList.get(position));
        holder.ratingBar.setRating(rates.get(position));
        holder.item_totalprice.setText(rup_tag.concat(prices_arrayList.get(position)));
        holder.cart_noofitems.setText(quantity_arrayList.get(position));
        holder.cut.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int change_price=0;
                order_database cutting = new order_database(context);
                cutting.delete_data(names_arrayList.get(holder.getAdapterPosition()));
                names_arrayList.remove(holder.getAdapterPosition());
                images_arrayList.remove(holder.getAdapterPosition());
                rates.remove(holder.getAdapterPosition());
                prices_arrayList.remove(holder.getAdapterPosition());
                quantity_arrayList.remove(holder.getAdapterPosition());
                if(names_arrayList.isEmpty()){
                    total_count.setText("Rs 0");
                    full_total.setText("Rs 0");
                    empty_cart.setVisibility(View.VISIBLE);
                }
                else {
                    for (int i =0; i<prices_arrayList.size();i++){
                        change_price = change_price + Integer.parseInt(prices_arrayList.get(i));
                    }

                    total_count.setText("Rs " + String.valueOf(change_price));
                    full_total.setText("Rs " + String.valueOf(change_price+200+500));
                }
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return names_arrayList.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView item_image;
        TextView item_name;
        RatingBar ratingBar;
        TextView item_totalprice;
        TextView cart_noofitems;  //This is amount of item quantity
        TextView quantity;        //This is quantity heading
        ConstraintLayout main_layout;
        ImageView cut;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            item_image = itemView.findViewById(R.id.cart_itemimage);
            cut = itemView.findViewById(R.id.cut_item);
            item_name =  itemView.findViewById(R.id.cart_itemname);
            ratingBar = itemView.findViewById(R.id.cart_itemrating);
            item_totalprice = itemView.findViewById(R.id.cart_totalitemprice);
            quantity = itemView.findViewById(R.id.quantity);
            cart_noofitems = itemView.findViewById(R.id.cart_noofitems);
            main_layout = itemView.findViewById(R.id.const_layout);
        }
    }

}

