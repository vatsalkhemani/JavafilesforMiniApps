package com.example.vatsal.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView t;
    SeekBar s;
    CountDownTimer c;
    Button goButton;
    boolean counterIsActive=false;
    public void Reset(){
        t.setText("0:30");
        s.setProgress(30);
        s.setEnabled(true);
        c.cancel();
        goButton.setText("GO");
        counterIsActive=false;
    }
    public void buttonClicked(View view){
        if(counterIsActive)
        {
            Reset();

        }
        else {
            counterIsActive = true;
            s.setEnabled(false);
            goButton.setText("STOP!");
            c=new CountDownTimer(s.getProgress() * 1000 + 40, 1000) {

                @Override
                public void onTick(long l) {
                    updateTimer((int) l / 1000);
                }

                @Override
                public void onFinish() {
                    MediaPlayer m = MediaPlayer.create(getApplicationContext(), R.raw.swsound);
                    m.start();
                    Reset();
                }
            }.start();
        }
    }
    public void updateTimer(int secondsLeft)
    {
        int minutes=secondsLeft/60;
        int seconds=secondsLeft-(minutes*60);
        String secondString=Integer.toString(seconds);
        if(seconds <= 9){
            secondString = "0" + secondString;
        }
        t.setText(Integer.toString(minutes) + ":" + secondString);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s=findViewById(R.id.timerSeekBar);
        t=findViewById(R.id.countdownTextView);
        goButton=findViewById(R.id.goButton);
        s.setMax(600);
        s.setProgress(30);
        s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimer(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
