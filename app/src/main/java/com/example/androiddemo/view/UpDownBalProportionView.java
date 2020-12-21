package com.example.androiddemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.androiddemo.utils.DisplayUtils;


/**
 * @author: amos
 * @date: 2020/5/27 15:51
 * @description:
 */
public class UpDownBalProportionView extends View {
    public UpDownBalProportionView(Context context) {
        super(context);
        init(context);
    }

    public UpDownBalProportionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public UpDownBalProportionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public UpDownBalProportionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private int mUp, mDown, mBal, mTotal;
    private int mWidth, mHeight;
    private Paint mProgressPaint;
    private int mGap;

    private void init(Context context) {
        mProgressPaint = new Paint();
        mProgressPaint.setAntiAlias(true);
        mProgressPaint.setStyle(Paint.Style.FILL);

        mGap = DisplayUtils.INSTANCE.dp2px(context, 8);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mTotal <= 0){
            return;
        }
        //裁剪画布
        Path clipPath = new Path();
        RectF mRectF = new RectF();
        mRectF.set(0, 0, mWidth, mHeight);
        clipPath.addRoundRect(mRectF, mHeight / 2f, mHeight / 2f, Path.Direction.CW);
        canvas.clipPath(clipPath);

        //绘制涨家数
        mProgressPaint.setColor(Color.parseColor("#E03C34"));
        int upProgress = getSingleWidth(mUp);
        RectF upRectF = new RectF();
        upRectF.set(0, 0, upProgress, mHeight);
        canvas.drawRect(upRectF, mProgressPaint);


        //绘制平家数
        mProgressPaint.setColor(Color.parseColor("#999999"));
        int balProgress = getSingleWidth(mBal);
        RectF balRectF = new RectF();
        balRectF.set(upProgress, 0, upProgress + balProgress, mHeight);
        canvas.drawRect(balRectF, mProgressPaint);

        //绘制跌家数
        mProgressPaint.setColor(Color.parseColor("#1EA373"));
        int downProgress = getSingleWidth(mDown);
        RectF downRectF = new RectF();
        downRectF.set(upProgress + balProgress, 0, upProgress + balProgress + upProgress + downProgress, mHeight);
        canvas.drawRect(downRectF, mProgressPaint);

        //绘制分隔
        Path path = new Path();
        path.moveTo(upProgress, 0);
        path.lineTo(upProgress + mGap, 0);
        path.lineTo(upProgress, mHeight);
        path.lineTo(upProgress - mGap, mHeight);
        path.close();
        mProgressPaint.setColor(Color.parseColor("#FFFFFF"));
        canvas.drawPath(path, mProgressPaint);
        if(mBal > 0){
            Path path2 = new Path();
            path2.moveTo(upProgress + balProgress, 0);
            path2.lineTo(upProgress + balProgress + mGap, 0);
            path2.lineTo(upProgress + balProgress, mHeight);
            path2.lineTo(upProgress + balProgress - mGap, mHeight);
            path2.close();
            mProgressPaint.setColor(Color.parseColor("#FFFFFF"));
            canvas.drawPath(path2, mProgressPaint);
        }

    }

    /**
     * @param up   涨
     * @param down 跌
     * @param bal  平
     */
    public void setData(int up, int down, int bal) {
        mUp = up;
        mDown = down;
        mBal = bal;
        mTotal = mUp + mDown + mBal;
        if (mTotal <= 0) {
            return;
        }
        postInvalidate();
    }

    private int getSingleWidth(int count) {
        return (int) (count * mWidth * 1.0f / mTotal);
    }
}
