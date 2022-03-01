package com.example.playingaudio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView textView;
    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2 = new MediaPlayer();
    private ImageView play;
    private ImageView back;
    private ImageView ahead;
    private ImageView next;
    private ImageView previous;
    private SurfaceView surfaceView;
    ArrayList<File> items1 = new ArrayList<>();
    String[] download_songs1;
    public int i;
    String var;

    protected void setMediaPlayer(ArrayList<File> item, String[] downloads, int pos){
        i = pos;
        if (i == item.size()) {
            i = 0;
        }
        var = downloads[i];
        textView.setText(var);
        mediaPlayer2.pause();
        Uri uri = Uri.parse(item.get(i).toString());
        mediaPlayer = MediaPlayer.create(MainActivity.this, uri);
        seekBar.setMax(mediaPlayer.getDuration());
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                i++;
                mediaPlayer.release();
                play.setImageResource(R.drawable.pause);
                setMediaPlayer(item, downloads, i);
                mediaPlayer.start();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent2 = getIntent();
        Bundle bundle1 = intent2.getExtras();
        items1 = (ArrayList) bundle1.getParcelableArrayList("arraylist");
        download_songs1 = intent2.getStringArrayExtra("list");
        i = intent2.getIntExtra("position", 0);
        try {
            AssetFileDescriptor afd = getAssets().openFd("beatsbars.mp4");
            mediaPlayer2.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(),afd.getLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
        surfaceView = findViewById(R.id.surfaceView);
        surfaceView.setKeepScreenOn(true);
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                mediaPlayer2.setDisplay(surfaceHolder);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        back = findViewById(R.id.back);
        ahead = findViewById(R.id.ahead);
        play = findViewById(R.id.imageView);
        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView);
        var = download_songs1[i];
        textView.setText(var);
        try {
            mediaPlayer2.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer2.setLooping(true);
        mediaPlayer2.start();
        setMediaPlayer(items1, download_songs1, i);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    mediaPlayer2.pause();
                    play.setImageResource(R.drawable.play);
                }
                else{
                    mediaPlayer.start();
                    mediaPlayer2.start();
                    play.setImageResource(R.drawable.pause);
                }
            }
        });
        seekBar.setMax(mediaPlayer.getDuration());
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,900);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()-15000);
            }
        });
        ahead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()+15000);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.release();
                play.setImageResource(R.drawable.pause);
                i++;
                setMediaPlayer(items1, download_songs1, i);
                mediaPlayer.start();
                mediaPlayer2.start();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.release();
                play.setImageResource(R.drawable.pause);
                if(i == 0){
                    i =  download_songs1.length - 1;
                    setMediaPlayer(items1, download_songs1, i);
                    mediaPlayer.start();
                    mediaPlayer2.start();
                }
                else{
                    i--;
                    setMediaPlayer(items1, download_songs1, i);
                    mediaPlayer.start();
                    mediaPlayer2.start();
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}