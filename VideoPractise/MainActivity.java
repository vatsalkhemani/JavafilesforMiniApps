package com.example.vatsal.videodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView v=(VideoView) findViewById(R.id.videoView);
        v.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.demovideo);
        MediaController m=new MediaController(this);
        m.setAnchorView(v);
        v.setMediaController(m);
        v.start();
    }
}
