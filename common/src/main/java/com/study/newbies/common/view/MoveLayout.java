package com.study.newbies.common.view;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 *
 * @author NewBies
 * @date 2018/9/1
 */
public class MoveLayout extends FrameLayout{

    /**
     * 记录是拖拉模式还是放大缩小模式
     */
    private int mode = 0;
    /**
     * 拖拉模式
     */
    private final int MODE_DRAG = 1;
    /**
     * 放大缩小模式
     */
    private final int MODE_ZOOM = 2;
    /**
     * 两个手指的开始距离
     */
    private float startDis;
    /**
     *  两个手指的中间点
     */
    private PointF midPoint;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int offsetX;
    private int offsetY;

    public MoveLayout(@NonNull Context context) {
        super(context);
    }

    public MoveLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MoveLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        startX = (int) event.getX();
        startY = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                endX = startX;
                endY = startY;
                break;
            case MotionEvent.ACTION_MOVE:
                if(mode == MODE_ZOOM){

                }
                else {
                    mode = MODE_DRAG;
                    offsetX = endX - startX;
                    offsetY = endY - startY;
                    ((FrameLayout.LayoutParams)getLayoutParams()).setMargins(getLeft() + offsetX, getTop() + offsetY,
                            getRight() + offsetX, getBottom() + offsetY);
                }
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                mode = MODE_ZOOM;
                //计算两个手指间的距离
                startDis = distance(event);
                //计算两个手指间的中间点
                // 两个手指并拢在一起的时候像素大于10
                if (startDis > 10f) {
                    midPoint = mid(event);
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                break;
            default:
                break;
        }

        return true;
    }

    /**
     * 计算两个手指间的距离
     */
    private float distance(MotionEvent event) {
        //第二个点的坐标与第一个点的坐标差
        float dx = event.getX(1) - event.getX(0);
        float dy = event.getY(1) - event.getY(0);
        //使用勾股定理返回两点之间的距离
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * 计算两个手指间的中间点
     */
    private PointF mid(MotionEvent event) {
        float midX = (event.getX(1) + event.getX(0)) / 2;
        float midY = (event.getY(1) + event.getY(0)) / 2;
        return new PointF(midX, midY);
    }
}
