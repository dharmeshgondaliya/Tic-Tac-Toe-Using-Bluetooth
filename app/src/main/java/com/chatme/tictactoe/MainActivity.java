package com.chatme.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton ib = (ImageButton) findViewById(R.id.logoimage);
        final Handler handler = new Handler();
        final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
        final TextView timer = (TextView) findViewById(R.id.timer);
        timer.startAnimation(animation);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                timer.setText("2");
                timer.setTextColor(Color.BLUE);
                timer.startAnimation(animation);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        timer.setText("1");
                        timer.setTextColor(Color.BLUE);
                        timer.startAnimation(animation);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(getApplicationContext(),TicTacToe.class));
                                finish();
                            }
                        }, 1000);
                    }
                }, 1000);
            }
        },1000);
    }

    public void Start(View view) {
        startActivity(new Intent(getApplicationContext(),TicTacToe.class));
        finish();
    }
}