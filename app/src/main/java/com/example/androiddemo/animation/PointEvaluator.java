package com.example.androiddemo.animation;

import android.animation.TypeEvaluator;

/**
 * @author Menglingshuai
 * @date 2019-12-02.
 * email：mlsnatalie@163.com
 * description：
 */
public class PointEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        Point point = new Point(x, y);
        return point;
    }

}