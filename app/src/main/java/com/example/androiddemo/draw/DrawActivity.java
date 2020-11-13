package com.example.androiddemo.draw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androiddemo.R;

/**
 * @author mlsnatalie
 * @date 2019-06-13.
 * email：mlsnatalie@163.com
 * description：
 */
public class DrawActivity extends AppCompatActivity {

    private RadioButton rb_liangziduokong;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

//        final Paint mPaint = new Paint();
//        mPaint.setStrokeWidth(10);
//        mPaint.setColor(0xffff0000);
//        setContentView(new View(this) {
//            @Override
//            protected void onDraw(Canvas canvas) {
//                canvas.drawLine(0, 0, getWidth(), getHeight(), mPaint);
//            }
//        });

        rb_liangziduokong = (RadioButton) findViewById(R.id.rb_liangziduokong);

        rb_liangziduokong.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                float height = rb_liangziduokong.getHeight();
                float width = rb_liangziduokong.getWidth();
                float top = rb_liangziduokong.getTop();
                float bottom = rb_liangziduokong.getBottom();
                float left = rb_liangziduokong.getLeft();
                float right = rb_liangziduokong.getRight();

                Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(b);


                //文本画笔
                TextPaint textPaint = new TextPaint();
                textPaint.setAntiAlias(true);
                textPaint.setTextSize(20);
                //文本宽高
                String text = "20";
                float textWidth = textPaint.measureText(text);
                float textHeight = textPaint.getTextSize();


                // 横线起始点和结束点坐标
                float startX, startY, endX, endY;
                startX = right;
                startY = bottom;
                endX = startX + textWidth;
                endY = startY + textHeight;


                // 价格文本显示坐标
                float priceX, priceY;
                priceX = right;
                priceY = bottom;

                textPaint.setColor(Color.YELLOW);
                canvas.drawText(text, priceX, priceY, textPaint);
            }
        });
    }

}
