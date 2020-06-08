package com.example.vatsal.basicphrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void playPhrase(View view)
    {
        Button b=(Button) view;
        Log.i("Button pressed",b.getTag().toString());
        MediaPlayer m=MediaPlayer.create(this,getResources().getIdentifier(b.getTag().toString(),"raw",getPackageName()));
        m.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
