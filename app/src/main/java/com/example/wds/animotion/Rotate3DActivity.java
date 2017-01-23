package com.example.wds.animotion;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.wds.animotion.animation.Rotate3DAnimation;

public class Rotate3DActivity extends Activity {
    private ImageView iv_yamei;
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (android.widget.RelativeLayout)findViewById(R.id.relativeLayout);
        iv_yamei = (ImageView) findViewById(R.id.iv_yamei);

    }

    public void to3DRotate(View view) {
        float centerX = relativeLayout.getWidth() / 2f;
        float centerY = relativeLayout.getHeight() / 2f;
        Rotate3DAnimation rotate3DAnimation = new Rotate3DAnimation(0.0f, 360.0f, centerX, centerY, 0, true);
        rotate3DAnimation.setDuration(1000);
        rotate3DAnimation.setZAdjustment(2);
        rotate3DAnimation.setFillAfter(true);

        iv_yamei.startAnimation(rotate3DAnimation);
    }
}
