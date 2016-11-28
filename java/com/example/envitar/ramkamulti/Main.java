package com.example.envitar.ramkamulti;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.io.IOException;

public class Main extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ImageView image;
    int x = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                finish();
                System.exit(0);
            }
        });
        image = (ImageView) findViewById(R.id.imageView1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        media();
        timeOut();
    }

    private void media(){
        mediaPlayer = MediaPlayer.create(this, R.raw.coconut_song);
        mediaPlayer.setLooping(true);
        mediaPlayer.start(); // no need to call prepare(); create() does that for you
    }

    private void timeOut(){
        new CountDownTimer(4000, 1000) {
            public void onTick(long millisUntilFinished) {}
            public void onFinish() {
                if(x == 4){
                    x = 1;
                }
                else
                {
                    x++;
                }
                changeImage(x);
                start();
            }
        }.start();
    }

    private void changeImage(int x){
        switch(x){
            case 1: {
                image.setImageResource(R.drawable.coconut1);
                break;
            }
            case 2: {
                image.setImageResource(R.drawable.coconut2);
                break;
            }
            case 3: {
                image.setImageResource(R.drawable.coconut3);
                break;
            }
            case 4: {
                image.setImageResource(R.drawable.coconut4);
                break;
            }
        }
    }
}