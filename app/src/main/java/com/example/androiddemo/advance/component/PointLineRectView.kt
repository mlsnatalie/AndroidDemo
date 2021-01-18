package com.example.androiddemo.advance.component

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.example.androiddemo.utils.DisplayUtils.dp2px

/**
 * @author: mlsnatalie
 * @date: 2021/1/18 4:02 PM
 * @UpdateDate: 2021/1/18 4:02 PM
 * email：mlsnatalie@163.com
 * description：
 */
class PointLineRectView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {

    init {

    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //1.绘制颜色
//        canvas?.drawColor(Color.BLUE)

        //2.绘制点
//        val mPaint = Paint()
//        mPaint.color = Color.RED
//        mPaint.strokeWidth = 20f
//        mPaint.style = Paint.Style.FILL_AND_STROKE
//        canvas?.drawPoint(500f, 300f, mPaint)
//
//        canvas?.drawLine(0f, 0f, 300f, 300f, mPaint)

        //3.绘制矩形
//        val mPaint = Paint()
//        mPaint.color = Color.RED
//        mPaint.strokeWidth = 10f
//
////        canvas?.drawRect(100f, 100f, 500f, 500f, mPaint)
//
//        var rectF = RectF(100f, 100f, 800f, 200f)
//        var rect = Rect(100, 400, 800, 800)
////        canvas?.drawRect(rectF, mPaint)
////        canvas?.drawRect(rect, mPaint)
//
//        canvas?.drawRoundRect(rectF, 30f, 30f, mPaint)

        //4.绘制圆形
//        val mPaint = Paint()
//        mPaint.color = Color.RED
//        mPaint.strokeWidth = 10f
//
//        canvas?.drawCircle(500f, 500f, 100f, mPaint)

        //4.绘制圆弧
//        val mPaint = Paint()
//        mPaint.color = Color.RED
//        mPaint.strokeWidth = 10f
//
//        var rectF = RectF(200f, 200f, 800f, 800f)
//        canvas?.drawArc(rectF, 0f, 90f, true, mPaint)

        //5.绘制文字
        val mPaint = Paint()
        mPaint.color = Color.RED
        mPaint.textSize = context.dp2px(40f).toFloat()
        mPaint.style = Paint.Style.FILL_AND_STROKE
        //指定初始文本位置
//        canvas?.drawText("abcdef", 300f, 300f, mPaint)
        //指定文本每个字体位置
//        canvas?.drawPosText("abcde", floatArrayOf(100f, 100f, 200f, 200f, 300f, 300f, 400f, 400f, 500f, 500f), mPaint)
        //指定路径
        val path = Path()
        path.cubicTo(540f, 750f, 640f, 450f, 840f, 600f)
        canvas?.drawPath(path, mPaint) //画路径
        canvas?.drawTextOnPath("在Path上写的字:Carson_Ho", path, 50f, 0f, mPaint)


    }
}