package com.example.vatsal.connect3;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int a=0;
    boolean gameActive=true;
    public void dropIn(View view)
    {
        ImageView counter=(ImageView) view;
       int tc=Integer.parseInt(counter.getTag().toString());
       if(gameState[tc]==2 && gameActive==true){


       gameState[tc]=a;
        counter.setTranslationY(-1500);
        if(a==0){
        counter.setImageResource(R.drawable.yellow);
        a=1;}
        else {
            counter.setImageResource(R.drawable.red);
            a = 0;
        }
        counter.animate().translationYBy(1500).rotation(3600).setDuration(1
                00);
        for(int[] winningPosition : winningPositions)
        {
            if(gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2)
            {   gameActive=false;
                String winner="";
                if(a==1)
                {
                    winner="Yellow";
                }
                else
                {
                    winner="Red";
                }
                Toast.makeText(this, winner+" has won", Toast.LENGTH_SHORT).show();
                Button b=(Button)findViewById(R.id.playAgainButton);
                TextView t=(TextView)findViewById(R.id.winnerTextView);
                t.setText(winner + " has won   ");
                b.setVisibility(View.VISIBLE);
                t.setVisibility(View.VISIBLE);
            }

        }
       }
    }
    public void playAgain(View view){
        Button b=(Button)findViewById(R.id.playAgainButton);
        TextView t=(TextView)findViewById(R.id.winnerTextView);
        b.setVisibility(View.INVISIBLE);
        t.setVisibility(View.INVISIBLE);
        GridLayout g=(GridLayout)findViewById(R.id.gridLayout);
        for(int i=0; i<g.getChildCount(); i++) {
            ImageView counter = (ImageView)g.getChildAt(i);
            counter.setImageDrawable(null);

        }
        for(int i=0;i<9;i++)
        {
            gameState[i]=2;
        }

        a=0;
        gameActive=true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
