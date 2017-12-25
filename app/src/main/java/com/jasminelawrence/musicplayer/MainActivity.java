package com.jasminelawrence.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private TextView volumeTextView;
    private Button playButton,pauseButton, resetButton, volUpButton, volDownButton;
    private Button prevButton,nextButton;

    private float volume = (float)0.50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMediaPlayer = MediaPlayer.create(this, R.raw.baby_music_box_daniel_simion);

        volumeTextView = (TextView) findViewById(R.id.volume_text);

        playButton = (Button) findViewById(R.id.play_button);
          pauseButton = (Button) findViewById(R.id.pause_button);

        pauseButton.setEnabled(false);

         resetButton = (Button)findViewById(R.id.reset_button);
          volUpButton = (Button)findViewById(R.id.volup_button);
          volDownButton = (Button)findViewById(R.id.voldown_button);
        prevButton = (Button)findViewById(R.id.prev_button);
        nextButton = (Button)findViewById(R.id.next_button);


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


        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMediaPlayer.seekTo(0);

                Toast.makeText(getApplicationContext(), "Restarting song",Toast.LENGTH_SHORT).show();

                playButton.setEnabled(true);

            }
        });


        volUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (volume <1.0){

                    mMediaPlayer.setVolume(volume += .05, volume += .05);
                    volumeTextView.setText(String.valueOf(volume*100));
                    //TODO: format

                }


                Toast.makeText(getApplicationContext(), "Volume Up",Toast.LENGTH_SHORT).show();
            }
        });


        volDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (volume > .10){

                    mMediaPlayer.setVolume(volume -= .05, volume -= .05);
                    volumeTextView.setText(String.valueOf( volume*100));
                    //TODO: format


                }

                Toast.makeText(getApplicationContext(), "Volume down",Toast.LENGTH_SHORT).show();


            }
        });


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // mMediaPlayer.start();
                //Toast.makeText(getApplicationContext(), "Playing song",Toast.LENGTH_SHORT).show();
               // pauseButton.setEnabled(true);
                //playButton.setEnabled(false);

            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // mMediaPlayer.start();
                //Toast.makeText(getApplicationContext(), "Playing song",Toast.LENGTH_SHORT).show();
                // pauseButton.setEnabled(true);
                //playButton.setEnabled(false);

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
