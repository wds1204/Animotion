package com.example.wds.animotion.timeInterpolator;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.animation.BaseInterpolator;

/**
 * Created by wds on 2017/1/22.
 * Captain 加油吧!!!
 * GitHub:https://github.com/wds1204
 * Email:wdsmyhome@hotmail.com
 *  DeceAcceInterpolatorInterpolator:自定义先减速后加速的插值器
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
public class DeceAcceInterpolatorInterpolator extends BaseInterpolator {
    @Override
    public float getInterpolation(float input) {
        //(float)(Math.cos((input + 1) * Math.PI) / 2.0f) + 0.5f：写出类似这种形式

        //(0-a)^3

        return ((4*input-2)*(4*input-2)*(4*input-2))/16f + 0.5f;
    }
}
