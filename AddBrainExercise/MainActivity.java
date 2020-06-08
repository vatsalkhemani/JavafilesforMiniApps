package com.example.vatsal.braintrainer;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b;TextView sumTextView;
    ConstraintLayout gameLayout;
    Button button0,button1,button2,button3;
    ArrayList<Integer> answers=new ArrayList<Integer>();
    int location;
    int score=0;
    TextView timer;
    int noOfQuestions=0;
    TextView scoreTextView;
    Button playAgain;
    TextView res;
    public void playagain(View view){
        score=0;
        noOfQuestions=0;
        timer.setText("30s");
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(noOfQuestions));
        newQuestion();
        playAgain.setVisibility(View.INVISIBLE);
        res.setText("");
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timer.setText(String.valueOf(l/1000)+"s");

            }

            @Override
            public void onFinish() {
                res.setText("Done!");
                playAgain.setVisibility(View.VISIBLE);
            }
        }.start();
    }
    public void choose(View view){
        if(Integer.toString(location).equals(view.getTag().toString())){
            res.setText("Correct! ");
            score++;
        }
        else
        {
           res.setText("Wrong :( ");
        }
        noOfQuestions++;
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(noOfQuestions));
        newQuestion();
    }
    public void newQuestion()
    {

        Random rand=new Random();
        int x=rand.nextInt(21);
        int y=rand.nextInt(21);
        sumTextView.setText(Integer.toString(x) + "+" +Integer.toString(y));
        location = rand.nextInt(4);
        answers.clear();
        for(int i=0;i<4;i++){
            if(i==location){
                answers.add(x+y);
            }else{
                int wrongAnswer=rand.nextInt(41);
                while(wrongAnswer == x+y){
                    wrongAnswer=rand.nextInt(41);
                }
                answers.add(wrongAnswer);
            }

        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }
    public void start(View view)
    {
        b.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        playagain(findViewById(R.id.timerTextView));

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.goButton);
        sumTextView=findViewById(R.id.sumTextView);
        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        res=findViewById(R.id.resultTextView);
        playAgain=findViewById(R.id.playAgainButton);
        scoreTextView=findViewById(R.id.scoreTextView);
        timer=findViewById(R.id.timerTextView);
        b.setVisibility(View.VISIBLE);
        gameLayout=findViewById(R.id.gameLayout);
        gameLayout.setVisibility(View.INVISIBLE);


    }
}
