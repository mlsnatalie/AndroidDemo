package com.example.androiddemo.animation

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * @author Menglingshuai
 * @date 2019-12-02.
 * email：mlsnatalie@163.com
 * description：
 */
class MyAnimView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {
    companion object {
        const val RADIUS = 50f
    }
    private var currentPoint: Point? = null
    private var mPaint: Paint? = null

    init {
        mPaint = Paint(ANTI_ALIAS_FLAG)
        mPaint!!.color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (currentPoint == null) {
            currentPoint = Point(RADIUS, RADIUS)
            drawCircle(canvas)
            startAnimation()
        } else {
            drawCircle(canvas)
        }
    }

    private fun drawCircle(canvas: Canvas?) {
        val x = currentPoint?.x ?: 50f
        val y = currentPoint?.y ?: 50f
        canvas?.drawCircle(x, y, RADIUS, mPaint)
    }

    private fun startAnimation() {
        val startPoint = Point(RADIUS, RADIUS)
        val endPoint = Point(width - RADIUS, height - RADIUS)
        val anim = ValueAnimator.ofObject(PointEvaluator(), startPoint, endPoint)
        anim.addUpdateListener { animation ->
            currentPoint = animation.animatedValue as? Point
            Log.e("aaaddd", "currentPoint+++$currentPoint")
            invalidate()
        }
        anim.duration = 5000L
        anim.start()
    }

}