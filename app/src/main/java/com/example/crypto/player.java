package com.example.crypto;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URI;

public class player extends AppCompatActivity {

    private String VIDEO_SAMPLE ;
    private VideoView mVideoView;
    private String mediaName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        mVideoView = findViewById(R.id.myvideoView);

        MediaController controller = new MediaController(player.this);
        controller.setMediaPlayer(mVideoView);

        mVideoView.setMediaController(controller);

    }

    @Override
    protected void onStart() {
        super.onStart();

        initializePlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();

        releasePlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            mVideoView.pause();
        }
    }

    private Uri getMedia(String mediaName) {
        Bundle extras = getIntent().getExtras();


        if (extras != null) {
            mediaName = extras.getString("videopath");
            Toast.makeText(player.this,mediaName,Toast.LENGTH_LONG).show();
        }
        return Uri.parse(mediaName);
    }

    private void initializePlayer() {
        Toast.makeText(player.this,"initilaizing",Toast.LENGTH_LONG).show();
        Uri videoUri = getMedia(mediaName);
        mVideoView.setVideoURI(videoUri);
        mVideoView.start();
    }

    private void releasePlayer() {
        mVideoView.stopPlayback();
    }
}