package com.example.wds.animotion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by wds on 2017/1/21.
 * Captain 加油吧!!!
 * GitHub:https://github.com/wds1204
 * Email:wdsmyhome@hotmail.com
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        /*Property Animation*/
    }



    public void goto3DActivity(View view) {
        startActivity(new Intent(this, Rotate3DActivity.class));
    }

    public void gotoLayoutActivity(View view) {
        startActivity(new Intent(this, LayoutAnimationActivity.class));
    }

    public void switchActivityAnimation(View view) {
        /*enter_anim:Activity被打开所需的动画，exit_anim:Activity被暂停时所需的动画*/
        Intent intent = new Intent(this, SwitchActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter_anim, R.anim.exit_anim2);
    }

    public void PropertyAnimation(View view) {

        Intent intent = new Intent(this, PropertyAnimationActivity.class);
        startActivity(intent);
    }

    public void pointMoveActivity(View view) {
        Intent intent = new Intent(this, PointMoveActivity.class);
        startActivity(intent);

    }
}
