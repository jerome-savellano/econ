package com.example.econ;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

import Utils.Animations;

/**
 * Created by jerome on 8/16/2016.
 */
public class Pollution extends ActionBarActivity implements View.OnClickListener{



    private RelativeLayout card1, card2, card3;
    private Button btnA1, btnA2, btnB, btnC;
    private Animations anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pollution);

        initializeComponents();
    }

    private void initializeComponents(){
        card1 = (RelativeLayout)findViewById(R.id.card1);
        card2 = (RelativeLayout)findViewById(R.id.card2);
        card3 = (RelativeLayout)findViewById(R.id.card3);

        btnA1 = (Button)findViewById(R.id.btnA1);
        btnA2 = (Button)findViewById(R.id.btnA2);
        btnB = (Button)findViewById(R.id.btnB);
        btnC = (Button)findViewById(R.id.btnC);

        btnA1.setOnClickListener(this);
        btnA2.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);

        anim = new Animations(this);

        card1.setVisibility(View.VISIBLE);
        anim.setAnimationFadeIn(card1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnA1:

                card1.setVisibility(View.GONE);
                card2.setVisibility(View.VISIBLE);

                anim.setAnimationFadeIn(card2);
                anim.setAnimationFadeOut(card1);

                break;
            case R.id.btnA2:

                card1.setVisibility(View.GONE);
                card3.setVisibility(View.VISIBLE);

                anim.setAnimationFadeOut(card1);
                anim.setAnimationFadeIn(card3);

                break;
            case R.id.btnB:
                finish();
                break;
            case R.id.btnC:
                finish();
                break;
        }
    }
}
