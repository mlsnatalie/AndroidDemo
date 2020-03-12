package com.example.androiddemo.draw;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author mlsnatalie
 * @date 2019-06-13.
 * email：mlsnatalie@163.com
 * description：
 */
public class DrawActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Paint mPaint = new Paint();
        mPaint.setStrokeWidth(10);
        mPaint.setColor(0xffff0000);
        setContentView(new View(this) {
            @Override
            protected void onDraw(Canvas canvas) {
                canvas.drawLine(0, 0, getWidth(), getHeight(), mPaint);
            }
        });
    }
}
