package com.example.Photomanagementsystem;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class recycler_home_adapter extends RecyclerView.Adapter<recycler_home_adapter.holder> {

    ArrayList<Uri> image_data = new ArrayList<>();
    public recycler_home_adapter(ArrayList<Uri> data) {
        this.image_data = data;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_view_recycler_view, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        Picasso.get()
                .load(image_data.get(position))
                .resize(400,400)
                .centerCrop()
                .into(holder.item_view_image);
    }

    @Override
    public int getItemCount() {
        return image_data.size();
    }

     public class holder extends RecyclerView.ViewHolder{
        private ImageView item_view_image;
        public holder(@NonNull View itemView) {
            super(itemView);
            item_view_image = itemView.findViewById(R.id.item_view_image);
        }
    }
}
