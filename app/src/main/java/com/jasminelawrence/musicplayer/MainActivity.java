package com.jasminelawrence.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMediaPlayer = MediaPlayer.create(this, R.raw.baby_music_box_daniel_simion);
    }

    public void playSong(View view){

        mMediaPlayer.start();
        Toast.makeText(getApplicationContext(), "Playing song",Toast.LENGTH_SHORT).show();




    }


    public void pauseSong(View view){
        mMediaPlayer.pause();

        Toast.makeText(getApplicationContext(), "Pausing song",Toast.LENGTH_SHORT).show();


    }

    public void resetSong(View view){
        mMediaPlayer.seekTo(0);

        Toast.makeText(getApplicationContext(), "Restarting song",Toast.LENGTH_SHORT).show();


    }
}
