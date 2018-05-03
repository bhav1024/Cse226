package com.ebookfrenzy.floatingbuttonapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Main2Activity extends AppCompatActivity {
    FloatingActionButton b1,b2,b3;
    Animation o,cl,c,a;
    Boolean b=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tryfor);
        b1=(FloatingActionButton)findViewById(R.id.fab);
        b2=(FloatingActionButton)findViewById(R.id.fabo);
        b3=(FloatingActionButton)findViewById(R.id.faboo);
        o= AnimationUtils.loadAnimation
                (getApplicationContext(),R.anim.open);
        cl= AnimationUtils.loadAnimation
                (getApplicationContext(),R.anim.close);
        c= AnimationUtils.loadAnimation
                (getApplicationContext(),R.anim.clock);
        a= AnimationUtils.loadAnimation
                (getApplicationContext(),R.anim.anti);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b) {
                    b1.startAnimation(a);
                    b2.startAnimation(cl);
                    b3.startAnimation(cl);
                    b2.setClickable(false);
                    b3.setClickable(false);
                    b=false;
                }
                else{
                    b1.startAnimation(c);
                    b2.startAnimation(o);
                    b3.startAnimation(o);
                    b3.setClickable(true);
                    b2.setClickable(true);
                    b=true;
                }

            }
        });
    }

}
