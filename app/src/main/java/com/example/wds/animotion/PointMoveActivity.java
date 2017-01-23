package com.example.wds.animotion;

import android.app.Activity;
import android.os.Bundle;

public class PointMoveActivity extends Activity {

    public static android.content.Context mainAcitivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_move);
        mainAcitivity = getApplication().getApplicationContext();

    }
}
