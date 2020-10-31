//package com.example.androiddemo.support;
//
//import android.animation.ValueAnimator;
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.graphics.Path;
//import android.graphics.RectF;
//import android.support.annotation.ColorRes;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.constraint.ConstraintLayout;
//import android.support.v4.content.ContextCompat;
//import android.text.TextUtils;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.animation.DecelerateInterpolator;
//import android.widget.FrameLayout;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.constraintlayout.widget.ConstraintLayout;
//
//import com.example.androiddemo.R;
//import com.jindashi.yingstock.R;
//import com.jindashi.yingstock.live.tools.FormatTool;
//
//import me.jessyan.autosize.utils.AutoSizeUtils;
//
///**
// * @author: amos
// * @date: 2019/12/26 16:38
// * @description:
// */
//public class AnswerOptionComponent extends FrameLayout {
//    public AnswerOptionComponent(@NonNull Context context) {
//        this(context, null);
//    }
//
//    public AnswerOptionComponent(@NonNull Context context, @Nullable AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//    public AnswerOptionComponent(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init(context);
//    }
//
//    private ConstraintLayout cl_option_container; //
//    private TextView tv_option_content; //选项内容
//    private TextView tv_correct_tips;
//    private TextView tv_people_count; //人数
//    private int mWidth, mHeight;
//    private int mRadius;
//    private int mStrokeWidth;
//    private DrawType mDrawType; //绘制的类型
//    private Paint mProgressPaint;
//    private float mProgressOffsetX; //进度偏移量
//    private ValueAnimator mAnimator;
//    private RectF mRectF;
//
//    private void init(Context context) {
//        setClickable(true);
//        View view = LayoutInflater.from(context).inflate(R.layout.layout_answer_option_component, null);
//        addView(view, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        mStrokeWidth = AutoSizeUtils.pt2px(context, 2);
//        mRadius = AutoSizeUtils.pt2px(context, 54);
//        mDrawType = DrawType.NONE;
//    }
//
//    //设置选项字体颜色
//    private void setOptionTextColor(@ColorRes int colorRes) {
//        try {
//            tv_option_content.setTextColor(ContextCompat.getColor(getContext(), colorRes));
//        } catch (Exception e) {
//
//        }
//    }
//
//    private void initProgressPaint() {
//        if (mProgressPaint == null) {
//            mProgressPaint = new Paint();
//            mProgressPaint.setAntiAlias(true);
//            mProgressPaint.setStyle(Paint.Style.FILL);
//            mProgressPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_live_08B6FB));
//        }
//    }
//
//    /**
//     * 进度动画
//     *
//     * @param maxProgress
//     */
//    private void onStartAnimator(float maxProgress) {
//        if (mAnimator != null && mAnimator.isRunning()) {
//            return;
//        }
//        mAnimator = ValueAnimator.ofFloat(0f, maxProgress);
//        mAnimator.setDuration(300);
//        mAnimator.setInterpolator(new DecelerateInterpolator());
//        mAnimator.setRepeatCount(0);
//        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                mProgressOffsetX = (float) animation.getAnimatedValue();
//                invalidate();
//            }
//        });
//        mAnimator.start();
//    }
//
//    /**
//     * 根据比例或者进度的最大值
//     *
//     * @param proportion 比例  (小值 / 大值)
//     * @return
//     */
//    private float getMaxProgress(float proportion) {
//        return mWidth * proportion;
//    }
//
//    private void onStartDraw(DrawType type, float proportion) {
//        initProgressPaint();
//        if (type == DrawType.CORRECT) {
//            mProgressPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_live_08B6FB));
//        } else if (type == DrawType.ERROR) {
//            mProgressPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_live_F74857_50));
//        } else if (type == DrawType.NORMAL) {
//            mProgressPaint.setColor(ContextCompat.getColor(getContext(), R.color.color_live_DBDBDB));
//        }
//        post(new Runnable() {
//            @Override
//            public void run() {
//                onStartAnimator(getMaxProgress(proportion));
//            }
//        });
//    }
//
//    private void onResetProgress() {
//        setOptionTextColor(R.color.color_live_333333);
//        setBackgroundResource(R.drawable.shape_live_answer_option_normal);
//        tv_people_count.setText("");
//        tv_correct_tips.setVisibility(GONE);
//        mDrawType = DrawType.NONE;
//    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        mWidth = getMeasuredWidth();
//        mHeight = getMeasuredHeight();
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        if (mDrawType != DrawType.NONE) {
//            initProgressPaint();
//            //裁剪画布
//            Path clipPath = new Path();
//            mRectF = new RectF();
//            mRectF.set(0, 0, mWidth, mHeight);
//            clipPath.addRoundRect(mRectF, mHeight / 2f, mHeight / 2f, Path.Direction.CW);
//            canvas.clipPath(clipPath);
//
//            RectF progressRectF = new RectF();
//            progressRectF.set(0, 0, mProgressOffsetX, mHeight);
//            canvas.drawRect(progressRectF, mProgressPaint);
//        }
//    }
//
//    @Override
//    protected void onFinishInflate() {
//        super.onFinishInflate();
//        cl_option_container = findViewById(R.id.cl_option_container);
//        tv_option_content = findViewById(R.id.tv_option_content);
//        tv_correct_tips = findViewById(R.id.tv_correct_tips);
//        tv_people_count = findViewById(R.id.tv_people_count);
//        onResetProgress();
//    }
//
//    @Override
//    public AnswerOptionComponent setOptionContent(String optionContent) {
//        tv_option_content.setText(TextUtils.isEmpty(optionContent) ? "" : optionContent);
//        return this;
//    }
//
//    private void setShowCorrectBtn(boolean isShow) {
//        tv_correct_tips.setVisibility(isShow ? VISIBLE : GONE);
//    }
//
//    private void setPeopleCount(String peopleCount) {
//        tv_people_count.setText(TextUtils.isEmpty(peopleCount) ? "" : peopleCount);
//    }
//
//    @Override
//    public AnswerOptionComponent setAnsweringWatch() { //答题中 观看状态
//        onResetProgress();
//        setBackgroundResource(R.drawable.shape_answer_un_click_bg);
//        setOptionTextColor(R.color.color_live_999999);
//        return this;
//    }
//
//    @Override
//    public AnswerOptionComponent setAnswering() { //答题中状态
//        /*setBackgroundResource(R.drawable.shape_live_answer_option_normal);
//        setOptionTextColor(R.color.color_live_333333);*/
//        onResetProgress();
//        return this;
//    }
//
//    @Override
//    public AnswerOptionComponent setAnsweringSelectedStatus() {//正在答题 选中
//        onResetProgress();
//        setBackgroundResource(R.drawable.shape_live_answer_option_selected);
//        setOptionTextColor(R.color.color_live_white);
//        return this;
//    }
//
//    @Override
//    public void setResultCorrect(float proportion, boolean isShowCorrectBtn, int peopleCount) { //回答结果真确
//        onResetProgress();
//        mDrawType = DrawType.CORRECT;
//        onStartDraw(mDrawType, proportion);
//        setShowCorrectBtn(isShowCorrectBtn);
//        if (isShowCorrectBtn) {
//            setBackgroundResource(R.drawable.shape_live_anser_option_correct_no_people);
//        }
//        setPeopleCount(FormatTool.formatPeopleCountWord(peopleCount < 0 ? 0 : peopleCount));
//    }
//
//    @Override
//    public void setResultError(float proportion, int peopleCount) { //回答结果错误
//        onResetProgress();
//        mDrawType = DrawType.ERROR;
//        onStartDraw(mDrawType, proportion);
//        setPeopleCount(FormatTool.formatPeopleCountWord(peopleCount < 0 ? 0 : peopleCount));
//    }
//
//    @Override
//    public void setResultNormal(float proportion, int peopleCount) {
//        onResetProgress();
//        mDrawType = DrawType.NORMAL;
//        onStartDraw(mDrawType, proportion);
//        setPeopleCount(FormatTool.formatPeopleCountWord(peopleCount < 0 ? 0 : peopleCount));
//    }
//
//    private enum DrawType {
//        NONE, //默认
//        CORRECT, //正确
//        ERROR, //错误
//        NORMAL //其他
//    }
//}
