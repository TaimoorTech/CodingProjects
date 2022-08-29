package com.example.dbms_cs031_cs010_cs006_cs008;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class Electronics_Items_Recycler_Adapter extends RecyclerView.Adapter<Electronics_Items_Recycler_Adapter.myViewHolder> {

    ArrayList<Bitmap> images_arrayList = new ArrayList<>();
    ArrayList<Bitmap> images_arrayList_edited = new ArrayList<>();
    ArrayList<String> names_arrayList = new ArrayList<>();
    ArrayList<String> prices_arrayList = new ArrayList<>();
    ArrayList<String> detailed_info_arraylist = new ArrayList<>();
    order_database ordering;
    ArrayList<Float> rates = new ArrayList<>();
    Context context;

    public Electronics_Items_Recycler_Adapter(Context c,ArrayList<String> model, ArrayList<Bitmap> img_item,
                                              ArrayList<Float> rating, ArrayList<String> price,
                                              ArrayList<String> d_info, ArrayList<Bitmap> img_item_edited){
        context = c;
        images_arrayList = img_item;
        images_arrayList_edited = img_item_edited;
        names_arrayList = model;
        rates = rating;
        prices_arrayList = price;
        detailed_info_arraylist = d_info;
        ordering = new order_database(c);
    }


    @NonNull
    @Override
    public Electronics_Items_Recycler_Adapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =  inflater.inflate(R.layout.electronic_items_design_view, parent, false);
        return new myViewHolder(view);
    }

    public void filter(Context c,ArrayList<Bitmap> img_item, ArrayList<String> model, ArrayList<Float> rating,
                       ArrayList<String> price, ArrayList<String> d_info, ArrayList<Bitmap> img_item_edited){
        context = c;
        names_arrayList = model;
        images_arrayList = img_item;
        rates = rating;
        prices_arrayList = price;
        detailed_info_arraylist = d_info;
        images_arrayList_edited = img_item_edited;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull Electronics_Items_Recycler_Adapter.myViewHolder holder, int position) {
        String rup_tag = "Rs.";
        holder.item_image.setImageBitmap(images_arrayList.get(position));
        holder.item_name.setText(names_arrayList.get(position));
        holder.ratingBar.setRating(rates.get(position));
        holder.item_price.setText(rup_tag.concat(prices_arrayList.get(position)));
//        holder.main_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ordering.data_insertion_database(names_arrayList.get(holder.getAdapterPosition()),
//                        detailed_info_arraylist.get(holder.getAdapterPosition()),
//                        rates.get(holder.getAdapterPosition()).toString(),
//                        prices_arrayList.get(holder.getAdapterPosition()));
//            }
//        });

        holder.main_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bmp = images_arrayList_edited.get(holder.getAdapterPosition());
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                Intent intent = new Intent(context, product_detail.class);
                intent.putExtra("model_name", names_arrayList.get(holder.getAdapterPosition()));
                intent.putExtra("model_detailed_information", detailed_info_arraylist.get(holder.getAdapterPosition()));
                intent.putExtra("model_image", byteArray);
                intent.putExtra("model_rate", String.valueOf(rates.get(holder.getAdapterPosition())));
                intent.putExtra("model_price", prices_arrayList.get(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return names_arrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView item_image;
        TextView item_name;
        RatingBar ratingBar;
        TextView item_price;
        ConstraintLayout main_layout;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            item_image = itemView.findViewById(R.id.items_display_image);
            item_name =  itemView.findViewById(R.id.items_display_text);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            item_price = itemView.findViewById(R.id.rupees);
            main_layout = itemView.findViewById(R.id.main_layout);
        }
    }
}
