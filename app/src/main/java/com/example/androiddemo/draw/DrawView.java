package com.example.androiddemo.draw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.androiddemo.R;

/**
 * @author: mlsnatalie
 * @date: 2020/10/27 6:49 PM
 * @UpdateDate: 2020/10/27 6:49 PM
 * email：mlsnatalie@163.com
 * description：
 */
public class DrawView extends LinearLayout {
//    public CircleView(Context context) {
//        super(context);
//    }
//
//    public CircleView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init(context);
//        getAttrs(attrs);
//    }
//
//    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    public DrawView(Context context) {
        this(context, null);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        getAttrs(attrs);
    }

    private Context mContext;
    private int mBackGroundColor, mForegroundColor;
    private int mWidth, mHeight;
    private int mStrokeWidth;
    private Paint mProgressPaint;
    private CircleModel model = CircleModel.MODEL_RING;
    private float mSweepAngle; //角度
    private float mStartAngle = 90;//开始角度
    private LinearGradient mGradient;

    private void init(Context context) {
        mContext = context;
        mStrokeWidth = dp2px(8);
        mProgressPaint = getPaint();
    }

//    private void getAttrs(AttributeSet attrs) {
//        if (attrs == null) {
//            return;
//        }
//        @SuppressLint({"CustomViewStyleable", "Recycle"}) TypedArray array = mContext.obtainStyledAttributes(attrs, R.styleable.CircleProgressView);
//        mBackGroundColor = array.getColor(R.styleable.CircleProgressView_num_progress_background, Color.parseColor("#ffffff"));
//        mForegroundColor = array.getColor(R.styleable.CircleProgressView_num_progress_foreground, Color.parseColor("#4785FF"));
//        array.recycle();
//    }

    private void getAttrs(AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        @SuppressLint("CustomViewStyleable") TypedArray array = mContext.obtainStyledAttributes(attrs, R.styleable.CircleView);
        if (array == null) {
            return;
        }
        mBackGroundColor = array.getColor(R.styleable.CircleView_num_progress_background, Color.parseColor("#ffffff"));
        mForegroundColor = array.getColor(R.styleable.CircleView_num_progress_foreground, Color.parseColor("#4785FF"));
        array.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
    }

    /**
     * 获取画笔
     */
    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(mStrokeWidth);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        return paint;
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (model == CircleModel.MODEL_DETAIL) {
            //绘制背景
            int cx = mWidth / 2;
            int cy = mHeight / 2;
            int radius = mWidth / 2 - mStrokeWidth;
            mProgressPaint.setShader(null);
            mProgressPaint.setColor(mBackGroundColor);
            canvas.drawCircle(cx, cy, radius, mProgressPaint);

            //绘制前景 进度
            int left = mWidth / 2 - radius;
            int top = mHeight / 2 - radius;
            int right = mWidth - mStrokeWidth;
            int bottom = mHeight - mStrokeWidth;
            @SuppressLint("DrawAllocation") RectF oval = new RectF(left, top, right, bottom);
            mProgressPaint.setColor(mForegroundColor);
            canvas.drawArc(oval, -180, 90, false, mProgressPaint);
            return;
        }

        if (model == CircleModel.MODEL_SINGLE) {
            mBackGroundColor = Color.parseColor("#F0F0F0");
            int backGroundStrokeWidth = dp2px(4);
            int foreGroundStrokeWidth = dp2px(8);
            mProgressPaint.setStrokeWidth(backGroundStrokeWidth);

            //绘制背景
            int cx = mWidth / 2;
            int cy = mHeight / 2;
            int radius = mWidth / 2 - backGroundStrokeWidth;
            mProgressPaint.setShader(null);
            mProgressPaint.setColor(mBackGroundColor);
            canvas.drawCircle(cx, cy, radius, mProgressPaint);

            mProgressPaint.setStrokeWidth(foreGroundStrokeWidth);
            radius = mWidth / 2 - foreGroundStrokeWidth;
            //绘制前景 进度
            int left = mWidth / 2 - radius;
            int top = mHeight / 2 - radius;
            int right = mWidth - foreGroundStrokeWidth;
            int bottom = mHeight - foreGroundStrokeWidth;
            @SuppressLint("DrawAllocation") RectF oval = new RectF(left, top, right, bottom);
            mGradient = new LinearGradient(left, top, right, bottom,
                    Color.parseColor("#FFB121")
                    , Color.parseColor("#FF7A21"),
                    Shader.TileMode.MIRROR);
            mProgressPaint.setShader(mGradient);
            canvas.drawArc(oval, mStartAngle, mSweepAngle, false, mProgressPaint);
            return;

        }

        if (model == CircleModel.MODEL_RING) {
            //绘制背景
            int cx = mWidth / 2;
            int cy = mHeight / 2;
            int radius = mWidth / 2 - mStrokeWidth;
//            mProgressPaint.setShader(null);
//            mProgressPaint.setColor(mBackgroundColor);
//            canvas.drawCircle(cx, cy, radius, mProgressPaint);

            //绘制前景 进度
            int left = mWidth / 2 - radius;
            int top = mHeight / 2 - radius;
            int right = mWidth - mStrokeWidth;
            int bottom = mHeight - mStrokeWidth;
            RectF oval = new RectF(left, top, right, bottom);

            mProgressPaint.setColor(mBackGroundColor);
            canvas.drawArc(oval, -180, 180, false, mProgressPaint);

            mProgressPaint.setColor(mForegroundColor);
            canvas.drawArc(oval, -180, mSweepAngle, false, mProgressPaint);
            return;
        }

        if (model == CircleModel.MODEL_LINE) {
//            Paint paint = new Paint();
//            paint.setStrokeWidth(10);
//            paint.setColor(Color.RED);
//            canvas.drawLine(0, 0, 50, 50, paint);

            //文本画笔
            TextPaint textPaint = new TextPaint();
            textPaint.setAntiAlias(true);
            textPaint.setTextSize(60);
            //文本宽高
            String text = "20";
            float textWidth = textPaint.measureText(text);
            float textHeight = textPaint.getTextSize();


            // 横线起始点和结束点坐标
//        float startX, startY, endX, endY;
//        startX = right;
//        startY = bottom;
//        endX = startX + textWidth;
//        endY = startY + textHeight;


            // 价格文本显示坐标
            float priceX, priceY;
            priceX = 100;
            priceY = 200;

            textPaint.setColor(Color.RED);
            canvas.drawText(text, priceX, priceY, textPaint);

        }
    }

    /**
     * 设置画图的类型
     * @param model
     */
    public void setModel(CircleModel model) {
        this.model = model;
    }

    /**
     * 设置分数
     */
    public void set180Score(int score) {
        mSweepAngle = 180 * score / 100f;
        postInvalidate();
    }

    /**
     * 设置分数
     */
    public void set360Score(int score) {
        mSweepAngle = 360 * score / 100f;
        postInvalidate();
    }

    public enum CircleModel {
        MODEL_DETAIL,
        MODEL_SINGLE,
        MODEL_RING,
        MODEL_LINE,
        MODE_NONE
    }

    /**
     * dp转px
     */
    private int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }
}
