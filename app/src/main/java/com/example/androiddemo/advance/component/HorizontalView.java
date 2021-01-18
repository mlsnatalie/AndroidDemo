package com.example.androiddemo.advance.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * @author: mlsnatalie
 * @date: 2021/1/8 8:56 PM
 * @UpdateDate: 2021/1/8 8:56 PM
 * email：mlsnatalie@163.com
 * description：
 */
public class HorizontalView extends ViewGroup {

    private Context mContext;

    public HorizontalView(Context context) {
        super(context);
    }

    public HorizontalView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizontalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public HorizontalView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
