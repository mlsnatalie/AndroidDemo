package com.example.androiddemo.advance.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.androiddemo.R;

/**
 * @author: mlsnatalie
 * @date: 2021/1/8 4:36 PM
 * @UpdateDate: 2021/1/8 4:36 PM
 * email：mlsnatalie@163.com
 * description：与上面的继承系统控件的自定义View不同，继承View的自定义View实现起来要稍微复杂一些。其不只 是要实现onDraw（）方法，
 * 而且在实现过程中还要考虑到wrap_content属性以及padding 属性的设置；为了 方便配置自己的自定义 View，还会对外提供自定义的属性。
 * 另外，如果要改变触控的逻辑，还要重写 onTouchEvent（）等触控事件的方法。按照上面的例子我们再写一个RectView类继承View来画一个正方 形，代码如下所示。
 */
public class RectView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mColor = Color.RED;

    public RectView(Context context) {
        super(context);
        initDraw();
    }

    public RectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //用 TypedArray 来获取自定义的属性集 R.styleable.RectView，这个 RectView 就是我们在XML中定义的 name的值，然后通过TypedArray的getColor方法来获取自定义的属性值
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RectView);
        mColor = typedArray.getColor(R.styleable.RectView_rect_color, Color.RED);
        typedArray.recycle();

        initDraw();
    }

    public RectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDraw();
    }

    public RectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initDraw();
    }

    private void initDraw() {
        mPaint.setColor(mColor);
        mPaint.setStrokeWidth(3f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;
        canvas.drawRect(0 + paddingLeft, 0 + paddingTop, width + paddingRight, height + paddingBottom, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.AT_MOST && heightMeasureSpec == MeasureSpec.AT_MOST) {
            setMeasuredDimension(600, 600);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(600, heightSpecSize);
        } else if (heightMeasureSpec == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, 600);
        }
    }
}
