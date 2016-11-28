package com.example.envitar.ramkamulti;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new CountDownTimer(4000, 1000) {
            TextView c = (TextView) findViewById(R.id.tekst);
            public void onTick(long millisUntilFinished) {
                c.setTextColor(Color.rgb(0,0,0));
                c.setText(" " + ((millisUntilFinished / 1000)-1) + " ");
            }
            public void onFinish() {
                c.setText("Start!");
                ValueAnimator anim = new ValueAnimator();
                anim.setIntValues(Color.rgb(255,255,255), Color.rgb(0,0,0));
                anim.setEvaluator(new ArgbEvaluator());
                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_splash_screen);
                        rl.setBackgroundColor((Integer)valueAnimator.getAnimatedValue());
                    }
                });
                anim.setDuration(4000);
                anim.start();
                new CountDownTimer(4000, 1000) {
                    public void onTick(long millisUntilFinished) {}
                    public void onFinish() {
                        startActivity(new Intent(getApplicationContext(), Main.class ));
                        finish();
                    }
                }.start();
                //ImageView iv = (ImageView) findViewById(R.id.foto);
                //iv.setImageResource(R.drawable.bower);
            }

        }.start();
    }

}
