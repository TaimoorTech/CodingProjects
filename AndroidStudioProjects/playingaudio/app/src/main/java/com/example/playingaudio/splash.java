package com.example.playingaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class splash extends AppCompatActivity {
    ArrayList<File> items = new ArrayList<>();
    ArrayList<File> filtered_items = new ArrayList<>();
    String[] download_songs;
    String[] durations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Dexter.withContext(splash.this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        items = mp3Songs(Environment.getExternalStorageDirectory());
                        Collections.sort(items);
                        download_songs = new String[items.size()];
                        for(int j=0; j<items.size(); j++){
                            download_songs[j] = items.get(j).getName();
                        }
                        Arrays.sort(download_songs, String.CASE_INSENSITIVE_ORDER);
                        for (int i=0; i<download_songs.length; i++){
                            String check = download_songs[i].toLowerCase(Locale.ROOT);
                            for (int j=0; j<download_songs.length; j++){
                                if(items.get(j).getName().toLowerCase(Locale.ROOT).equals(check)){
                                    filtered_items.add(items.get(j));
                                    break;
                                }
                            }
                        }
                        durations = new String[filtered_items.size()];
                        for(int m = 0; m<filtered_items.size(); m++){
                            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
                            mmr.setDataSource(filtered_items.get(m).getAbsolutePath());
                            String dur = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);



                            Long time = Long.parseLong(dur);
                            String finalTimerString = "";
                            String secondsString = "";

                            // Convert total duration into time
                            int hours = (int) (time / (1000 * 60 * 60));
                            int minutes = (int) (time % (1000 * 60 * 60)) / (1000 * 60);
                            int seconds = (int) ((time % (1000 * 60 * 60)) % (1000 * 60) / 1000);

                            // Add hours if there
                            if (hours > 0) {
                                finalTimerString = hours + ":";
                            }

                            // Prepending 0 to seconds if it is one digit
                            if (seconds < 10) {
                                secondsString = "0" + seconds;
                            } else {
                                secondsString = "" + seconds;
                            }

                            finalTimerString = finalTimerString + minutes + ":" + secondsString;

                            durations[m] = finalTimerString;
                        }
                        for(int k=0; k<download_songs.length; k++){
                            download_songs[k] = download_songs[k].replace(".mp3", "");
                        }
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                })
                .check();
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(splash.this, list_of_songs.class);
                    intent.putExtra("song", filtered_items);
                    intent.putExtra("converted", download_songs);
                    intent.putExtra("duration", durations);
                    startActivity(intent);
                }
            }
        };thread.start();
    }
    public ArrayList<File> mp3Songs(File file){
        ArrayList<File> list_of_songs = new ArrayList<>();
        File[] songs = file.listFiles();
        if(songs != null){
            for (File files: songs){
                if(!files.isHidden() && files.isDirectory()){
                    list_of_songs.addAll(mp3Songs(files));
                }
                else{
                    if(files.getName().endsWith(".mp3") && !files.getName().startsWith(".")){
                        list_of_songs.add(files);
                    }
                }
            }
        }
        return list_of_songs;
    }
}