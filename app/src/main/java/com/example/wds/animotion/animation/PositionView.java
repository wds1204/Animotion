package com.example.wds.animotion.animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.example.wds.animotion.CustomEvaluator.PositionEvaluator;

/**
 * Created by wds on 2017/1/22.
 * Captain 加油吧!!!
 * GitHub:https://github.com/wds1204
 * Email:wdsmyhome@hotmail.com
 */
public class PositionView extends View {
    private static final String TAG = "PositionView";
    private final Paint paint;
    private float RADIUS = 20f;
    private PositionPoint currentPoint;

    public PositionView(Context context) {
        this(context, null);
    }

    public PositionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PositionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (currentPoint == null) {
            currentPoint = new PositionPoint(RADIUS, RADIUS);
            drawCircle(canvas);
            startProperAnimation();
        } else {
            drawCircle(canvas);
        }
    }

    private void startProperAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new PositionEvaluator(), getPoint(20f, 100f+RADIUS), getPoint(getWidth() - 20f, 100f+RADIUS));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (PositionPoint) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setDuration(5000).start();

    }

    /**
     * 画一个圆
     *
     * @param canvas
     */
    private void drawCircle(Canvas canvas) {

        float cx =/*得到当前原点的X轴坐标*/currentPoint.getX();
        float cy =/*得到当前原点的y轴坐标*/currentPoint.getY();
        Log.d(TAG, "cx==" + cx + ",cy==" + cy);
        canvas.drawCircle(cx, cy, RADIUS, paint);
    }

    /**
     * 得到PositionPoint对象
     *
     * @param x
     * @param y
     * @return
     */
    public PositionPoint getPoint(float x, float y) {
        return new PositionPoint(x, y);
    }

    /*===================原点的内部类，X轴和Y轴===================*/
    public  class PositionPoint {
        public float x;
        public float y;

        public PositionPoint(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }
    }
}
