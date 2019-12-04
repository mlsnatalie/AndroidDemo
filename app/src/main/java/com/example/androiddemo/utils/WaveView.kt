package com.example.androiddemo.utils

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import kotlin.math.min

/**
 * @author Menglingshuai
 * @date 2019-12-04.
 * email：mlsnatalie@163.com
 * description：
 */
class WaveView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {

    /**
     * 圆形背景画笔
     */
    private var mBgPaint: Paint? = null
    /**
     * 圆形背景颜色
     */
    private var mBgColor = 0x66FFFFFF
    /**
     * 圆形背景的半径
     */
    private var mBgRadius = 0f
    /**
     * 圆形背景最大半径比例
     */
    private var mMaxRadiusRate = 0.85f
    /**
     * 扩散水波的颜色
     */
    private val mCircleEdgeColor_green = 0x2fffd1
    private val mCircleEdgeColor_red = 0xFF4081
    private val mCircleEdgeColor_yellow = 0xfeff38
    private val colors = arrayOf(mCircleEdgeColor_green, mCircleEdgeColor_yellow, mCircleEdgeColor_red)

    /**
     * 阴影颜色
     */
    private val mCircleShadowColor = 0x3a0909
    /**
     * 扩散水波的画笔
     */
    private var mCircleWavePaint: Paint? = null
    /**
     * 扩散水波默认半径
     */
    private val mDefaultWaveRadius = 0f
    /**
     * 当前扩散水波的半径
     */
    private var mCurrentWaveRadius: Float = 0.toFloat()


    /**
     * 扩散水波执行时间
     */
    private val mDuration: Long = 2000

    /**
     * 水波动画
     */
    private var mAnimator_green: ValueAnimator? = null
    private var mAnimator_yellow: ValueAnimator? = null
    private var mAnimator_red: ValueAnimator? = null

    private var valueAnimators = arrayOfNulls<ValueAnimator>(3)

    /**
     * 动画集
     */
    private var mAnimatorSet: AnimatorSet? = null

    init {
        initBgPaint()
        initCirclePaint()

        valueAnimators.forEachIndexed { index, valueAnimator ->
            initAnimation(index)
        }

        initAnimatorSet()


    }

    /**
     * 初始化背景画笔
     */
    private fun initBgPaint() {
        mBgPaint = Paint()
        mBgPaint?.strokeWidth = 5f
        mBgPaint?.color = mBgColor
        mBgPaint?.style = Paint.Style.FILL
        mBgPaint?.isAntiAlias = true
    }

    /**
     * 初始化水波圆圈的画笔
     */
    private fun initCirclePaint() {
        mCircleWavePaint = Paint()
        mCircleWavePaint?.strokeWidth = 3f
        mCircleWavePaint?.color = mCircleEdgeColor_green
        mCircleWavePaint?.style = Paint.Style.STROKE
        mCircleWavePaint?.isAntiAlias = true

        //设置圆环周围阴影效果  加上阴影必须取消硬件加速  没了硬件加速刷新UI导致卡卡的感觉 官方推荐阴影适合加在静态的图像上
//        setLayerType(LAYER_TYPE_SOFTWARE, null)
//        mCircleWavePaint?.setShadowLayer(30f, 0f, 0f, mCircleShadowColor)
    }

    /**
     * 初始化动画
     */
    private fun initAnimation(animationP: Int) {
        valueAnimators[animationP] = ValueAnimator.ofFloat(0f, 1f)
        valueAnimators[animationP]?.duration = 2000L
        valueAnimators[animationP]?.interpolator = DecelerateInterpolator()
        valueAnimators[animationP]?.addUpdateListener {
            val v = it.animatedFraction
            mCurrentWaveRadius = mDefaultWaveRadius + mBgRadius * v
            mCircleWavePaint?.color = colors[animationP]

            if (v > 0.9) {
                mCircleWavePaint?.alpha = ((1 - v + 0.4) * 100).toInt()
            } else {
                mCircleWavePaint?.alpha = ((v + 0.2) * 100).toInt()
            }

            mCircleWavePaint?.strokeWidth = 2 + 3 * v
            invalidate()
        }
    }

    /**
     * 初始化动画集
     */
    private fun initAnimatorSet() {
        mAnimatorSet = AnimatorSet()
        mAnimatorSet?.play(valueAnimators[1])?.before(valueAnimators[2])?.after(valueAnimators[0])

        mAnimatorSet?.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                mAnimatorSet?.start()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mBgRadius = min(w, h) * mMaxRadiusRate / 2.0f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawBg(canvas)
        drawWaveCircle(canvas)

    }

    /**
     * 画圆形的背景
     *
     * @param canvas 画笔
     */
    private fun drawBg(canvas: Canvas?) {
        canvas?.drawCircle(width / 2f, height / 2f, mBgRadius, mBgPaint)
    }

    /**
     * 画水波圆圈
     *
     * @param canvas 画布
     */
    private fun drawWaveCircle(canvas: Canvas?) {
        canvas?.drawCircle(width / 2f, height / 2f, mCurrentWaveRadius, mCircleWavePaint)
    }

    /**
     * 开启动画
     */
    fun startAnimation() {
        mAnimatorSet?.start()
    }

    /**
     * 暂停动画
     */
    fun pauseAnimation() {
        mAnimatorSet?.pause()
    }

    /**
     * 停止动画
     */
    fun stopAnimation() {
        mAnimatorSet?.end()
    }


}