package com.example.androiddemo.advance.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.androiddemo.R;

/**
 * @author: mlsnatalie
 * @date: 2021/1/8 7:59 PM
 * @UpdateDate: 2021/1/8 7:59 PM
 * email：mlsnatalie@163.com
 * description：
 */
public class TitleBar extends RelativeLayout {

    private Context mContext;
    private ImageView iv_titlebar_left;
    private TextView tv_titlebar_title;
    private ImageView iv_titlebar_right;
    private RelativeLayout layout_titlebar_rootlayout;
    private int mColor = Color.BLUE;
    private int mTextColor = Color.WHITE;
    private String titlename;

    public TitleBar(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(mContext).inflate(R.layout.view_customtitle, this, true);
        iv_titlebar_left = findViewById(R.id.iv_titlebar_left);
        tv_titlebar_title = findViewById(R.id.tv_titlebar_title);
        iv_titlebar_right = findViewById(R.id.iv_titlebar_right);
        layout_titlebar_rootlayout = (RelativeLayout) findViewById(R.id.layout_titlebar_rootlayout);
        //设置背景颜色
        layout_titlebar_rootlayout.setBackgroundColor(mColor);
        //设置标题文字颜色
        tv_titlebar_title.setTextColor(mTextColor);
        setTitle(titlename);
    }

    private void initTypedArray() {
        TypedArray typedArray = mContext.obtainStyledAttributes(R.styleable.TitleBar);
        mColor = typedArray.getColor(R.styleable.TitleBar_title_text_color, Color.RED);
        mTextColor = typedArray.getColor(R.styleable.TitleBar_title_text_color, Color.WHITE);
        titlename = typedArray.getString(R.styleable.TitleBar_title_text);
        //获取资源后要及时回收
        typedArray.recycle();
    }

    public void setTitle(String titlename) {
        if (!TextUtils.isEmpty(titlename)) {
            tv_titlebar_title.setText(titlename);
        }
    }

    public void setLeftListener(OnClickListener onClickListener) {
        iv_titlebar_left.setOnClickListener(onClickListener);
    }

    public void setRightListener(OnClickListener onClickListener) {
        iv_titlebar_right.setOnClickListener(onClickListener);
    }

}
