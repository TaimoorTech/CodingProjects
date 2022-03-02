package com.example.playingaudio;

import android.content.Context;
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

public class recycling_search_songs extends RecyclerView.Adapter<recycling_search_songs.MyViewHolder>{
    String search;
    String[] songs_list;
    ArrayList<File> downloads;
    Context context;

    public recycling_search_songs(Context c, String[] songs, ArrayList<File> s3, String se){
        search = se;
        songs_list =  songs;
        downloads = s3;
        context = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View setting_view = inflater.inflate(R.layout.designing_songs, parent, false);
        return new recycling_search_songs.MyViewHolder(setting_view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
