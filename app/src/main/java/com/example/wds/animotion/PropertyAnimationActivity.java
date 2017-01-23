package com.example.wds.animotion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by wds on 2017/1/21.
 * Captain 加油吧!!!
 * GitHub:https://github.com/wds1204
 * Email:wdsmyhome@hotmail.com
 */
public class PropertyAnimationActivity extends Activity {
    public static Context mainAcitivity;
    private TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainAcitivity = getApplication().getApplicationContext();
        setContentView(R.layout.activity_property_animation);
        findViews();

        changeViewColor();
        win10Rotation();

        /**理解插值器和估值器
         * TimeInterpolator:时间插值器，它的作用是根据时间流逝的百分比来计算出当前属性值改变的百分比，
         * 系统预置的有LinearInterpolator(线性插值器：匀速动画）、AccelerateDecelerateInterprolator(减速插值器)等。
         * TypeEvaluator：类型固执算法，估值器，它的作用是根据当前属性改变的百分比来计算改变后的属性值，
         * 系统预置的有IntEvaluator(针对整型属性）、FloatEvaluator(针对浮点型属性)和ArgbEvalutor(针对Color属性)，
         * 属性动画中的插值器和估值器很重要，它们是实现非匀速动画的重要手段。
         */


    }

    /**
     * Win10开机小圆点旋转动画
     */
    private void win10Rotation() {
        /*如果不对view指定旋转中心点则是相对自身的中心点旋转*/
        ObjectAnimator rotation1 = ObjectAnimator.ofFloat(ivPoint1, "rotation", 0, 360);
        /*这是相对view的坐标*/
        ivPoint1.setPivotX(0);
        ivPoint1.setPivotY(100);
        rotation1.setDuration(2000);
        ObjectAnimator rotation2 = ObjectAnimator.ofFloat(ivPoint2, "rotation", 0, 360);

        rotation2.setStartDelay(150*1);
        rotation2.setDuration(150*1 + 2000);
        ObjectAnimator rotation3 = ObjectAnimator.ofFloat(ivPoint3, "rotation", 0, 360);

        rotation3.setStartDelay(150*2);
        rotation3.setDuration(150*2 + 2000);
        ObjectAnimator rotation4 = ObjectAnimator.ofFloat(ivPoint4, "rotation", 0, 360);

        rotation4.setStartDelay(150*3);
        rotation4.setDuration(150*3 + 2000);
        ObjectAnimator rotation5 = ObjectAnimator.ofFloat(ivPoint5, "rotation", 0, 360);

        rotation5.setStartDelay(150*4);
        rotation5.setDuration(150*4 + 2000);

        final AnimatorSet animatorSet = new AnimatorSet();


        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animatorSet.start();
            }
        });
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.play(rotation1).with(rotation2).with(rotation3).with(rotation4).with(rotation5);
        animatorSet.start();
    }

    /**改变view的背景色，3秒内从红色到蓝色的渐变，动画无限循环且会有反转的效果*/
    private void changeViewColor() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animator = ObjectAnimator.ofInt(view, "backgroundColor", /*红色*/0XFFFF8080,/*蓝色*/ 0xFF8080FF);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.5f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.5f);
        scaleX.setRepeatCount(ValueAnimator.INFINITE);
        scaleY.setRepeatCount(ValueAnimator.INFINITE);
        scaleX.setRepeatMode(ValueAnimator.REVERSE);
        scaleY.setRepeatMode(ValueAnimator.REVERSE);
        animatorSet.setDuration(2000);
        animatorSet.playTogether(animator, scaleX,scaleY);
        animatorSet.start();
    }


    private LinearLayout ivPoint1;
    private LinearLayout ivPoint2;
    private LinearLayout ivPoint3;
    private LinearLayout ivPoint4;
    private LinearLayout ivPoint5;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-01-22 14:27:42 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        view = (TextView) findViewById(R.id.view);
        ivPoint1 = (LinearLayout)findViewById( R.id.iv_point1 );
        ivPoint2 = (LinearLayout)findViewById( R.id.iv_point2 );
        ivPoint3 = (LinearLayout)findViewById( R.id.iv_point3 );
        ivPoint4 = (LinearLayout)findViewById( R.id.iv_point4 );
        ivPoint5 = (LinearLayout)findViewById( R.id.iv_point5 );
    }


}
