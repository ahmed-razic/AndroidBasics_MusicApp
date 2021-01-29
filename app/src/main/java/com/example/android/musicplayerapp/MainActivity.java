package com.example.android.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.billie_jean);

        Button playButton = findViewById(R.id.play);
        Button pauseButton = findViewById(R.id.pause);
        Button seekButton = findViewById(R.id.seek);
        EditText inputTimeEditView = findViewById(R.id.input_time);

        View.OnClickListener playOnClick = v -> mediaPlayer.start();
        playButton.setOnClickListener(playOnClick);

        View.OnClickListener pauseOnClick = v -> mediaPlayer.pause();
        pauseButton.setOnClickListener(pauseOnClick);

        View.OnClickListener seekOnClick = v -> {
            int inputTime = Integer.parseInt(inputTimeEditView.getText().toString());
            mediaPlayer.seekTo(inputTime);
            mediaPlayer.start();
        };
        seekButton.setOnClickListener(seekOnClick);



    }
}