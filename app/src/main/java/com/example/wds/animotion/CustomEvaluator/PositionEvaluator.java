package com.example.wds.animotion.CustomEvaluator;

import android.animation.TypeEvaluator;
import android.util.Log;

import com.example.wds.animotion.PointMoveActivity;
import com.example.wds.animotion.animation.PositionView;

/**
 * Created by wds on 2017/1/22.
 * Captain 加油吧!!!
 * GitHub:https://github.com/wds1204
 * Email:wdsmyhome@hotmail.com
 *
 * 实现正弦曲线的轨迹：Y轴做正弦振动，X轴做匀速运动
 */
public class PositionEvaluator implements TypeEvaluator {
    private static final String TAG ="PositionEvaluator" ;

    //创建PositionView对象
    PositionView mPositionView = new PositionView(PointMoveActivity.mainAcitivity, null, 0);
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        PositionView.PositionPoint point1 = (PositionView.PositionPoint) startValue;
        PositionView.PositionPoint point2 = (PositionView.PositionPoint) endValue;


        //起始Y坐标
        /*起始XY坐标*/
        float startY = point1.getY();
        float startX = point1.getX();

        float endX = point2.getX();
        float endY = point2.getY();
        float absX = Math.abs(endX - startX);


        Log.e(TAG, "absX===" + absX + ",endX==" + endX + ", endY===" + endY);

        /*计算过后的X、Y坐标*/
        float x=getCurrentX(fraction,startX,absX);

        float y=getCurrentY(fraction,startY);
        Log.i(TAG, "x==" + x + ",y==" + y);
        return mPositionView.getPoint(x,y);
    }

    /**
     *
     * @param fraction 时间
     * @param startX 起始位置
     * @param absX 速度
     * @return
     */
    private float getCurrentX(float fraction, float startX, float absX) {
        float resultX = startX;
        if (fraction != 0f) {
            resultX = fraction * absX+startX;
        }
        return resultX;
    }


    /**
     * 计算出Y坐标
     *
     * @param fraction
     * @param startY
     * @return
     */
    private float getCurrentY(float fraction, float startY) {
        //轴上的增幅
        float range = startY;
        //加上point的半径不然会超出屏幕
        float resultY= (float) Math.sin((10 *fraction)*Math.PI)*range+startY+20f;
        return resultY;
    }
}
