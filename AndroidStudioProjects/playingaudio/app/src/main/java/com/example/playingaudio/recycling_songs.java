package com.example.playingaudio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recycling_songs extends RecyclerView.Adapter<recycling_songs.MyViewHolder> {
    String[] songs;
    Context context;

    public recycling_songs(Context c, String[] song){
        songs = song;
        context = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View setting_view = inflater.inflate(R.layout.designing_songs, parent, false);
        return new MyViewHolder(setting_view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.song_name.setText(songs[position]);
        holder.start.setImageResource(R.drawable.play);
    }

    @Override
    public int getItemCount() {
        return songs.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView song_name;
        ImageView start;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            song_name = itemView.findViewById(R.id.song_name);
            start = itemView.findViewById(R.id.start);
        }
    }
}
