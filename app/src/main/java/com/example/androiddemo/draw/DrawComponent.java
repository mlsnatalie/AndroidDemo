package com.example.androiddemo.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androiddemo.R;

/**
 * @author: mlsnatalie
 * @date: 2020/11/13 6:33 PM
 * @UpdateDate: 2020/11/13 6:33 PM
 * email：mlsnatalie@163.com
 * description：
 */
public class DrawComponent extends View {

    private Context context;

    public DrawComponent(@NonNull Context context) {
        super(context);
        init(context);
    }

    public DrawComponent(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DrawComponent(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public DrawComponent(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        init(context);
    }

    private void init(Context context) {
//        LayoutInflater.from(context).inflate(R.layout.component_draw, this);
        findView();
    }

    private void findView() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        float height = rb_liangziduokong.getHeight();
//        float width = rb_liangziduokong.getWidth();
//        float top = rb_liangziduokong.getTop();
//        float bottom = rb_liangziduokong.getBottom();
//        float left = rb_liangziduokong.getLeft();
//        float right = rb_liangziduokong.getRight();



        //文本画笔
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(20);
        //文本宽高
        String text = "40";
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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
