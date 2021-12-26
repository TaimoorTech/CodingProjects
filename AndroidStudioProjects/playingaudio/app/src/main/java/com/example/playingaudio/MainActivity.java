package com.example.playingaudio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.lang.reflect.Field;
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
    public int i;
    String var;
    Field[] fields = R.raw.class.getFields();

    protected void setMediaPlayer(){
        if (i == fields.length) {
            i = 0;
        }
        var = fields[i].getName();
        textView.setText(var);
        mediaPlayer2.pause();
        try {
            mediaPlayer = MediaPlayer.create(getApplicationContext(),
                    fields[i].getInt(var));
            seekBar.setMax(mediaPlayer.getDuration());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                i++;
                mediaPlayer.release();
                play.setImageResource(R.drawable.pause);
                setMediaPlayer();
                mediaPlayer.start();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        var = fields[i].getName();
        textView.setText(var);
        try {
            mediaPlayer2.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer2.setLooping(true);
        mediaPlayer2.start();
        setMediaPlayer();
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
                setMediaPlayer();
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
                    i = fields.length - 1;
                    setMediaPlayer();
                    mediaPlayer.start();
                    mediaPlayer2.start();
                }
                else{
                    i--;
                    setMediaPlayer();
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