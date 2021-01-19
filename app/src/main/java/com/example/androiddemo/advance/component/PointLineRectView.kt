package com.example.androiddemo.advance.component

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import com.example.androiddemo.R

/**
 * @author: mlsnatalie
 * @date: 2021/1/18 4:02 PM
 * @UpdateDate: 2021/1/18 4:02 PM
 * email：mlsnatalie@163.com
 * description：
 */
class PointLineRectView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

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
//        val mPaint = Paint()
//        mPaint.color = Color.RED
//        mPaint.textSize = context.dp2px(40f).toFloat()
//        mPaint.style = Paint.Style.FILL_AND_STROKE
//        //指定初始文本位置
////        canvas?.drawText("abcdef", 300f, 300f, mPaint)
//        //指定文本每个字体位置
////        canvas?.drawPosText("abcde", floatArrayOf(100f, 100f, 200f, 200f, 300f, 300f, 400f, 400f, 500f, 500f), mPaint)
//        //指定路径
//        val path = Path()
//        path.cubicTo(540f, 750f, 640f, 450f, 840f, 600f)
//        canvas?.drawPath(path, mPaint) //画路径
//        canvas?.drawTextOnPath("在Path上写的字:Carson_Ho", path, 50f, 0f, mPaint)
//
//        //6.绘制矢量图Picture
//        val picture = Picture()
//        val recordingCanvas = picture.beginRecording(500, 500)
//        recordingCanvas.translate(400f, 400f)
//        val mPaint = Paint()
//        mPaint.style = Paint.Style.FILL
//        mPaint.color = Color.BLUE
//        recordingCanvas.drawCircle(0f, 0f ,100f, mPaint)
//        picture.endRecording()
//
//        canvas?.drawPicture(picture, RectF(0f, 0f, picture.width.toFloat(), picture.height.toFloat()))

        //6.绘制位图bitmap

        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.icon_pic)

        // 后两个参数matrix, paint是在绘制时对图片进行一些改变
        // 后面会专门说matrix

        // 如果只是将图片内容绘制出来只需将传入新建的matrix, paint对象即可：
        // 后两个参数matrix, paint是在绘制时对图片进行一些改变
        // 后面会专门说matrix

        // 如果只是将图片内容绘制出来只需将传入新建的matrix, paint对象即可：
        // 记得选取一种获取Bitmap的方式
        // 注：图片左上角位置默认为坐标原点。
//        canvas?.drawBitmap(bitmap, Matrix(), Paint())


        // 参数 left、top指定了图片左上角的坐标(距离坐标原点的距离)：
//        canvas?.drawBitmap(bitmap, 100f, 100f, Paint())

        // 实例
        // 指定图片绘制区域
        // 仅绘制图片的二分之一
        // 参数（src，dst） = 两个矩形区域
        // Rect src：指定需要绘制图片的区域（即要绘制图片的哪一部分）
        // Rect dst 或RectF dst：指定图片在屏幕上显示(绘制)的区域
        // 下面我将用实例来说明

        // 实例
        // 指定图片绘制区域
        // 仅绘制图片的二分之一
        val src = Rect(0, 0, bitmap.width, bitmap.height)

        // 指定图片在屏幕上显示的区域
        val dst = Rect(100, 100, 1000, 1500)

        // 绘制图片
        canvas?.drawBitmap(bitmap, src, dst, null)

    }
}