package com.example.android.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.planet_sarkar);

        Button playButton = findViewById(R.id.play);
        Button pauseButton = findViewById(R.id.pause);
        Button seekButton = findViewById(R.id.seek);
        EditText inputTimeEditView = findViewById(R.id.input_time);


        playButton.setOnClickListener(v -> {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(mp -> Toast.makeText(MainActivity.this, "I'm done", Toast.LENGTH_LONG).show());
        });
        pauseButton.setOnClickListener(v -> mediaPlayer.pause());

        seekButton.setOnClickListener(v -> {
            int inputTime = Integer.parseInt(inputTimeEditView.getText().toString());
            mediaPlayer.seekTo(inputTime);
            mediaPlayer.start();
        });


    }
}
