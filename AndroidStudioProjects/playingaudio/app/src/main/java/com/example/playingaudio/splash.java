package com.example.playingaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
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
import java.util.Collections;

public class splash extends AppCompatActivity {
    ArrayList<File> items = new ArrayList<>();
    String[] download_songs;
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
                            download_songs[j] = items.get(j).getName().replace(".mp3", "");
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
                    intent.putExtra("song", items);
                    intent.putExtra("converted", download_songs);
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
                    if(files.getName().endsWith("mp3") && !files.getName().startsWith(".")){
                        list_of_songs.add(files);
                    }
                }
            }
        }
        return list_of_songs;
    }
}