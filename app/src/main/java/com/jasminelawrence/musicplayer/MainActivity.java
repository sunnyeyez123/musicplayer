package com.jasminelawrence.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private Button playButton,pauseButton, resetButton, volUpButton, volDownButton;
    private float volume = (float)1.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMediaPlayer = MediaPlayer.create(this, R.raw.baby_music_box_daniel_simion);



        playButton = (Button) findViewById(R.id.play_button);
          pauseButton = (Button) findViewById(R.id.pause_button);

        pauseButton.setEnabled(false);

         resetButton = (Button)findViewById(R.id.reset_button);
          volUpButton = (Button)findViewById(R.id.volup_button);
          volDownButton = (Button)findViewById(R.id.voldown_button);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMediaPlayer.start();
                Toast.makeText(getApplicationContext(), "Playing song",Toast.LENGTH_SHORT).show();
                pauseButton.setEnabled(true);
                playButton.setEnabled(false);

            }
        });



        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMediaPlayer.pause();
                Toast.makeText(getApplicationContext(), "Pausing song",Toast.LENGTH_SHORT).show();
                pauseButton.setEnabled(false);
                playButton.setEnabled(true);

            }
        });

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
