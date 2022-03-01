package com.example.playingaudio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class recycling_songs extends RecyclerView.Adapter<recycling_songs.MyViewHolder> {
    String[] songs;
    Context context;
    ArrayList<File> real_songs = new ArrayList<>();

    public recycling_songs(Context c, String[] song, ArrayList<File> s2){
        songs = song;
        context = c;
        real_songs = s2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View setting_view = inflater.inflate(R.layout.designing_songs, parent, false);
        return new MyViewHolder(setting_view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.song_name.setText(songs[position]);
        holder.start.setImageResource(R.drawable.play);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(context, MainActivity.class);
                intent4.putExtra("list", songs);
                intent4.putExtra("arraylist", real_songs);
                intent4.putExtra("position", position);
                context.startActivity(intent4);
            }
        });
        holder.song_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(context, MainActivity.class);
                intent5.putExtra("list", songs);
                intent5.putExtra("arraylist", real_songs);
                intent5.putExtra("position", position);
                context.startActivity(intent5);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songs.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView song_name;
        ImageView start;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            song_name = itemView.findViewById(R.id.song_name);
            start = itemView.findViewById(R.id.start);
            mainLayout = itemView.findViewById(R.id.mainlayout);
        }
    }
}
