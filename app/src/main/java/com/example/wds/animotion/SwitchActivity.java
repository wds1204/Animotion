package com.example.wds.animotion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SwitchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.enter_anim2, R.anim.exit_anim);
    }
}
