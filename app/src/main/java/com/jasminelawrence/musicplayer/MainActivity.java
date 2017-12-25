package com.jasminelawrence.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    float volume = (float)1.0;
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

    public void increaseVolume(View view){

        if (volume <1.0){

            mMediaPlayer.setVolume(volume += .1, volume += .1);

        }


        Toast.makeText(getApplicationContext(), "Volume Up",Toast.LENGTH_SHORT).show();


    }

    public void decreaseVolume(View view){
        if (volume > .10){

            mMediaPlayer.setVolume(volume -= .1, volume -= .1);

        }

        Toast.makeText(getApplicationContext(), "Volume down",Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onStop() {
        super.onStop();
        mMediaPlayer.release();
        mMediaPlayer = null;
    }
}
