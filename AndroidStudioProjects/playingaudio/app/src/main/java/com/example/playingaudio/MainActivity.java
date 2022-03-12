package com.example.playingaudio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
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
    private TextView timing_of_song;
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
    String[] durations;
    String[] download_songs1;
    public int i;
    String var;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    ImageView three_lines;
    ImageView pic_of_song;

    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        super.onBackPressed();
    }

    protected void setMediaPlayer(ArrayList<File> item, String[] downloads, int pos,
                                  String[] tm ){
        i = pos;
        if (i == item.size()) {
            i = 0;
        }
        var = downloads[i];
        textView.setText(var);
        timing_of_song.setText(tm[i]);
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(items1.get(i).getAbsolutePath());
        byte[] pic_data = mmr.getEmbeddedPicture();
        if(pic_data != null){
            Bitmap image = BitmapFactory.decodeByteArray(pic_data, 0, pic_data.length);
            pic_of_song.setImageBitmap(image);
        }
        else{
            pic_of_song.setImageResource(R.drawable.music);
        }

        mediaPlayer2.pause();

        Uri uri = Uri.parse(item.get(i).toString());
        mediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
        mediaPlayer.start();
        mediaPlayer2.start();
        play.setImageResource(R.drawable.pause);
        seekBar.setMax(mediaPlayer.getDuration());

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                i++;
                play.setImageResource(R.drawable.pause);
                setMediaPlayer(item, downloads, i, tm);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        back = findViewById(R.id.back);
        ahead = findViewById(R.id.ahead);
        play = findViewById(R.id.imageView);
        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView);
        timing_of_song = findViewById(R.id.timing);
        pic_of_song = findViewById(R.id.imageView2);


        navigationView = findViewById(R.id.navmenu);
        drawerLayout = findViewById(R.id.drawer);
        three_lines = findViewById(R.id.bars);

        toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        three_lines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });


        Intent intent2 = getIntent();
        Bundle bundle1 = intent2.getExtras();

        items1 = (ArrayList) bundle1.getParcelableArrayList("arraylist");
        download_songs1 = intent2.getStringArrayExtra("list");
        durations = intent2.getStringArrayExtra("dur");
        i = intent2.getIntExtra("position", 0);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.lists:
                        mediaPlayer.stop();
                        Intent intent = new Intent(MainActivity.this, list_of_songs.class);
                        intent.putExtra("song", items1);
                        intent.putExtra("converted", download_songs1);
                        intent.putExtra("duration", durations);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
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

        var = download_songs1[i];
        textView.setText(var);
        timing_of_song.setText(durations[i]);
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(items1.get(i).getAbsolutePath());
        byte[] pic_data = mmr.getEmbeddedPicture();
        if(pic_data != null){
            Bitmap image = BitmapFactory.decodeByteArray(pic_data, 0, pic_data.length);
            pic_of_song.setImageBitmap(image);
        }
        else{
            pic_of_song.setImageResource(R.drawable.music);
        }

        try {
            mediaPlayer2.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer2.setLooping(true);
        mediaPlayer2.start();
        setMediaPlayer(items1, download_songs1, i, durations);

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
                mediaPlayer.stop();
                play.setImageResource(R.drawable.pause);
                i++;
                setMediaPlayer(items1, download_songs1, i, durations);
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.release();
                play.setImageResource(R.drawable.pause);
                if(i == 0){
                    i =  download_songs1.length - 1;
                    setMediaPlayer(items1, download_songs1, i, durations);
                }
                else{
                    i--;
                    setMediaPlayer(items1, download_songs1, i, durations);
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