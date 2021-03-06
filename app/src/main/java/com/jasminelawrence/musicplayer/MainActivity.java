package com.jasminelawrence.musicplayer;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private int songCounter = 0;
    private TextView volumeTextView, trackNumberTextView;
    private Button playButton, pauseButton, resetButton, volUpButton, volDownButton;
    private Button prevButton, nextButton;

    private float volume = (float) 0.50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         ArrayList<Integer> songs = new ArrayList<Integer>();

         String file = "android.resource://" + getPackageName() + "/" + R.raw.carol_of_the_bells;

        final String[] playlist = new String []{"android.resource://" + getPackageName() + "/" + R.raw.carol_of_the_bells,
                "android.resource://" + getPackageName() + "/" + R.raw.herald,
                "android.resource://" + getPackageName() + "/" + R.raw.o_holy_night,
                "android.resource://" + getPackageName() + "/" + R.raw.we_wish_you_a_merry_christmas
               };



        mMediaPlayer = MediaPlayer.create(this, Uri.parse(file));

        volumeTextView = (TextView) findViewById(R.id.volume_text);
        trackNumberTextView = (TextView) findViewById(R.id.song_num);


        playButton = (Button) findViewById(R.id.play_button);
        pauseButton = (Button) findViewById(R.id.pause_button);
        pauseButton.setEnabled(false);

        resetButton = (Button) findViewById(R.id.reset_button);

        volUpButton = (Button) findViewById(R.id.volup_button);
        volDownButton = (Button) findViewById(R.id.voldown_button);

        prevButton = (Button) findViewById(R.id.prev_button);
        nextButton = (Button) findViewById(R.id.next_button);


        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                Toast.makeText(getApplicationContext(), "I'm Done!", Toast.LENGTH_SHORT).show();


            }
        });


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMediaPlayer.start();
                Toast.makeText(getApplicationContext(), "Playing song", Toast.LENGTH_SHORT).show();
                pauseButton.setEnabled(true);
                playButton.setEnabled(false);

            }
        });


        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMediaPlayer.pause();
                Toast.makeText(getApplicationContext(), "Pausing song", Toast.LENGTH_SHORT).show();
                pauseButton.setEnabled(false);
                playButton.setEnabled(true);

            }
        });


        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMediaPlayer.seekTo(0);

                Toast.makeText(getApplicationContext(), "Restarting song", Toast.LENGTH_SHORT).show();

                playButton.setEnabled(true);

            }
        });


        volUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (volume < 1.0) {

                    mMediaPlayer.setVolume(volume += .05, volume += .05);
                    volumeTextView.setText(String.valueOf(volume * 100));
                    //TODO: format

                }



                Toast.makeText(getApplicationContext(), "Volume Up", Toast.LENGTH_SHORT).show();
            }
        });


        volDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (volume > .10) {

                    mMediaPlayer.setVolume(volume -= .05, volume -= .05);
                    volumeTextView.setText(String.valueOf(volume * 100));
                    //TODO: format


                }

                Toast.makeText(getApplicationContext(), "Volume down", Toast.LENGTH_SHORT).show();


            }
        });


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (songCounter < playlist.length-1) {
                    songCounter += 1;

                } else {
                    songCounter = 0;
                }

                mMediaPlayer.reset();

                try {
                           /* load the new source */
                    Toast.makeText(getApplicationContext(), "Next song",Toast.LENGTH_SHORT).show();


                    mMediaPlayer.setDataSource(getApplicationContext(),Uri.parse(playlist[songCounter]));
                    /* Prepare the mediaplayer */
                    mMediaPlayer.prepare();


                } catch(IOException ie) {
                    Toast.makeText(getApplicationContext(), "No next song",Toast.LENGTH_SHORT).show();

                    ie.printStackTrace();

                }



       /* start */
                mMediaPlayer.start();
                pauseButton.setEnabled(true);
                playButton.setEnabled(false);


                trackNumberTextView.setText(String.valueOf(songCounter + 1)  );

            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (songCounter >0) {
                    songCounter -= 1;

                } else {
                    songCounter = 3;
                }

                mMediaPlayer.reset();

                try {
                           /* load the new source */
                    Toast.makeText(getApplicationContext(), "Previous song",Toast.LENGTH_SHORT).show();


                    mMediaPlayer.setDataSource(getApplicationContext(),Uri.parse(playlist[songCounter]));
                    /* Prepare the mediaplayer */
                    mMediaPlayer.prepare();


                } catch(IOException ie) {
                    Toast.makeText(getApplicationContext(), "No prev song",Toast.LENGTH_SHORT).show();

                    ie.printStackTrace();

                }



       /* start */
                mMediaPlayer.start();
                pauseButton.setEnabled(true);
                playButton.setEnabled(false);


                trackNumberTextView.setText(String.valueOf(songCounter + 1)  );


            }
        });


    }


    @Override
    protected void onStop() {
        super.onStop();
        mMediaPlayer.release();
        mMediaPlayer = null;
    }
}
