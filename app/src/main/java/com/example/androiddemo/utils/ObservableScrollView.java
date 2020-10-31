package com.example.androiddemo.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;

import androidx.core.widget.NestedScrollView;

/**
 * @author: mlsnatalie
 * @date: 2020/3/12 2:45 PM
 * @UpdateDate: 2020/3/12 2:45 PM
 * email：mlsnatalie@163.com
 * description：
 */

public class ObservableScrollView extends NestedScrollView {

    private OnScrollStatusListener onScrollStatusListener;

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ObservableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollStatusListener != null) {
            onScrollStatusListener.onScrolling();
            mHandler.removeCallbacksAndMessages(null);
            mHandler.sendEmptyMessageDelayed(0x01, 200);
        }
    }

    public void setOnScrollStatusListener(OnScrollStatusListener onScrollStatusListener) {
        this.onScrollStatusListener = onScrollStatusListener;
    }

    private Handler mHandler = new Handler() {

        @Override public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x01:
                    if (onScrollStatusListener != null) {
                        onScrollStatusListener.onScrollStop();
                    }
                    break;
            }
        }
    };

    @Override protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mHandler.removeCallbacksAndMessages(null);
    }

    public interface OnScrollStatusListener {
        void onScrollStop();

        void onScrolling();
    }
}
