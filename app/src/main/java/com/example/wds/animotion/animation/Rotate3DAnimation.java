package com.example.wds.animotion.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by wds on 2017/1/20.
 * Captain 加油吧!!!
 * GitHub:https://github.com/wds1204
 * Email:wdsmyhome@hotmail.com
 * <p/>
 * 自定义动画，围绕y轴旋转并且同时沿着z轴平移，从而实现3D效果
 */
public class Rotate3DAnimation extends Animation {
    private static final String TAG = "Rotate3DAnimation";
    private final boolean reverse;
    private final float depthZ;
    private final float fromDegrees;
    private final float centerX;
    private final float toDegrees;
    private final float centerY;
    private Camera camera;
    private int height;
    private int width;

    public Rotate3DAnimation(float fromDegrees, float toDegrees, float centerX, float centerY, float depthZ, boolean reverse) {
        this.fromDegrees = fromDegrees;
        this.toDegrees = toDegrees;
        this.centerX = centerX;
        this.centerY = centerY;
        this.depthZ = depthZ;
        this.reverse = reverse;
    }

    /**
     * 做一些初始化工作
     *
     * @param width Width of the object being animated
     * @param height Height of the object being animated
     * @param parentWidth Width of the animated object's parent
     * @param parentHeight Height of the animated object's parent
     */
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        this.width = width;
        this.height = height;
        Log.e(TAG, "int width=" + width + ", int height=" + height + ", int parentWidth=" + parentWidth + ", int parentHeight=" + parentHeight);
        camera = new Camera();
    }

    /**
     * 进行相应的矩阵变换
     *
     * @param interpolatedTime
     * @param t
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        Log.i(TAG, "interpolatedTime==" + interpolatedTime);
        float mFromDegrees = this.fromDegrees;
        //旋转的度数
        float degrees = mFromDegrees + (toDegrees - fromDegrees) * interpolatedTime;
        Log.i(TAG, "degrees==" + degrees);
        float centerX = this.centerX;
        float centerY = this.centerY;
        float depthZ = this.depthZ;

        Camera camera = this.camera;

        Matrix matrix = t.getMatrix();
        // 将当前的摄像头位置保存下来，以便变换进行完成后恢复成原位，  
        camera.save();
        /* camera.translate，这个方法接受3个参数，分别是x,y,z三个轴的偏移量，我们这里只将z轴进行了偏*/
        if (reverse) {
            camera.translate(0.0f, 0.0f, depthZ * interpolatedTime);
        } else {
            camera.translate(0.0f, 0.0f, depthZ * (1.0f - interpolatedTime));
        }
        // 是给我们的View加上旋转效果，在移动的过程中，视图还会移Y轴为中心进行旋转。
        camera.rotateY(degrees);
//        Camera在旋转的时候有这么一句 camera.getMatrix(matrix) ，
//        这是把Camera的旋转效果映射到Matrix里面去，所以要Camera部分的代码先执行，
//        再去调用Matrix的postTranslate()才能保证视图和中心点一起偏移，
//        不然的话中心点还没放到Matrix里去呢，自然就没有效果了。

        // 这个是将我们刚才定义的一系列变换应用到变换矩阵上面，调用完这句之后，我们就可以将camera的位置恢复了，以便下一次再使用。
        camera.getMatrix(matrix);
        // camera位置恢复  
        camera.restore();
        /* postTranslate()方法可以让视图和中心点同时移动,preTranslate()只会让视图发生移动*/
        matrix.preTranslate(-width/2f, -height/2f);
        matrix.postTranslate(width/2f, height/2f);


    }
}
