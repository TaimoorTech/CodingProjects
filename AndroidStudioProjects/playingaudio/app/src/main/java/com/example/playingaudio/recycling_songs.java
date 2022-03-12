package com.example.playingaudio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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
    ArrayList<File> real_songs;
    String[] main_downloads;
    ArrayList<File> main_songs = new ArrayList<File>();
    String[] times;
    String[] main_times;


    public recycling_songs(Context c, String[] m_song, ArrayList<File> main_arraylist, String[] song,
                           ArrayList<File> change_arraylist, String[] m_t, String[] t){
        main_downloads = m_song;
        main_songs = main_arraylist;
        songs = song;
        context = c;
        real_songs = change_arraylist;
        main_times = m_t;
        times = t;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View setting_view = inflater.inflate(R.layout.designing_songs, parent, false);
        return new MyViewHolder(setting_view);
    }

    public void filter(Context c, String[] filtered_song, ArrayList<File> filtered_arraylist,
                       String[] time){
        context = c;
        songs = filtered_song;
        real_songs = filtered_arraylist;
        times = time;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.song_name.setText(songs[position]);
        holder.start.setImageResource(R.drawable.play);
        holder.song_time.setText(times[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(context, MainActivity.class);
                intent4.putExtra("list", main_downloads);
                intent4.putExtra("arraylist", main_songs);
                intent4.putExtra("dur", main_times);
                intent4.putExtra("position", main_songs.indexOf(real_songs.get(position)));
                context.startActivity(intent4);
            }
        });
        holder.song_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(context, MainActivity.class);
                intent5.putExtra("list", main_downloads);
                intent5.putExtra("arraylist", main_songs);
                intent5.putExtra("dur", main_times);
                intent5.putExtra("position", main_songs.indexOf(real_songs.get(position)));
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
        TextView song_time;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            song_name = itemView.findViewById(R.id.song_name);
            start = itemView.findViewById(R.id.start);
            song_time = itemView.findViewById(R.id.dur);
            mainLayout = itemView.findViewById(R.id.mainlayout);
        }
    }
}
