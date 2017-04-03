package com.example.mypackage.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer musicControl;

    private Button playButton, pauseButton, resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        playButton = (Button) findViewById(R.id.playBtn);

        if (musicControl == null) {


        }

        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (musicControl != null) {

                    musicControl.start();

                    musicControl.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {

                            // Now that the sound file has finished playing, release the media player resources.
                            releaseMediaPlayer();
                        }
                    });
                }
            }
        });

        pauseButton = (Button) findViewById(R.id.pauseBtn);

        pauseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (musicControl != null) {
                    if (musicControl.isPlaying()) {
                        musicControl.pause();
                    }
                }
            }
        });

        resetButton = (Button) findViewById(R.id.resetBtn);

        resetButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (musicControl != null) {
                    musicControl.seekTo(musicControl.getDuration());
                } else {
                    musicControl = MediaPlayer.create(MainActivity.this, R.raw.dreamy);
                }
            }
        });

    }

    /**
     * +     * Clean up the media player by releasing its resources.
     * +
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (musicControl != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            musicControl.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            musicControl = null;
        }
    }
}
