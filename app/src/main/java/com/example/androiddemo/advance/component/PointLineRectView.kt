package com.example.androiddemo.advance.component

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


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

//        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.icon_pic)

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
//        val src = Rect(0, 0, bitmap.width, bitmap.height)
//
//        // 指定图片在屏幕上显示的区域
//        val dst = Rect(100, 100, 1000, 1500)
//
//        // 绘制图片
//        canvas?.drawBitmap(bitmap, src, dst, null)

        //7.Path的使用
        val path = Path()
        val paint = Paint()
        paint.color = Color.RED
        paint.strokeWidth = 10f
        paint.style = Paint.Style.STROKE

//        path.lineTo(400f, 500f);
//
//        // 将当前点移动到(300, 300)
//        path.moveTo(300f, 300f);
//
//        //连接点(900, 800)
//        path.lineTo(900f, 800f);
//
//        path.lineTo(200f, 700f)
//        // 闭合路径，即连接当前点和起点
//        // 即连接(200,700)与起点2(300, 300)
//        // 注:此时起点已经进行变换
//        path.close();
//
//        // 画出路径
//        canvas?.drawPath(path, paint);


//        path.lineTo(400f, 500f)
//        path.setLastPoint(300f, 300f)
//        //连接点(900, 800)
//        path.lineTo(900f, 800f);
//        path.lineTo(200f, 700f)
//        path.close();
//        canvas?.drawPath(path, paint);


//
//        canvas?.translate(400f, 500f);
//        // 起点是(0,0)，连接点(-100,0)
//        path.lineTo(-100f, 0f);
//        // 连接点(-100,200)
//        path.lineTo(-100f, 200f);
//        // 连接点(200,200)
//        path.lineTo(200f, 200f);
//        // 闭合路径，即连接当前点和起点
//        // 即连接(200,200)与起点是(0,0)
//        path.close();
//
//        // 画出路径
//        canvas?.drawPath(path, paint);

        // 将Canvas坐标系移到屏幕正中
//        canvas?.translate(400f, 500f);
//
//        // 起点是(0,0)，连接点(-100,0)
//        path.lineTo(-100f, 0f);
//        // 画圆：圆心=(0,0)，半径=100px
//        // 此时路径起点改变 = (0,100)（记为起点2）
//        // 起点改变原则：新画图形在x轴正方向的最后一个坐标
//        // 后面路径的变化以这个点继续下去
//        path.addCircle(0f, 0f, 100f, Path.Direction.CCW);
//
//        // 起点为：(0,100)，连接 (-100,200)
//        path.lineTo(-100f, 200f);
//        // 连接 (200,200)
//        path.lineTo(200f, 200f);
//
//        // 闭合路径，即连接当前点和起点（注：闭合的是起点2）
//        // 即连接(200,200)与起点2(0,100)
//        path.close();
//
//        // 画出路径
//        canvas?.drawPath(path, paint);


        // 将一个圆弧路径添加到一条直线路径里

        // 为了方便观察,平移坐标系
        // 将一个圆弧路径添加到一条直线路径里

        // 为了方便观察,平移坐标系
        canvas!!.translate(350f, 500f)

        // 先将原点(0,0)连接点(100,100)

        // 先将原点(0,0)连接点(100,100)
        path.lineTo(50f, 200f)

// 添加圆弧路径(2分之1圆弧)

        // 不连接最后一个点与圆弧起点

// 添加圆弧路径(2分之1圆弧)

        // 不连接最后一个点与圆弧起点
//        path.addArc(RectF(200f, 200f, 300f, 300f), 0f, 180f)
        // path.arcTo(oval,0,270,true);             // 与上面一句作用等价

        // 连接之前路径的结束点与圆弧起点
        // path.arcTo(oval,0,270,true);             // 与上面一句作用等价

        // 连接之前路径的结束点与圆弧起点
        path.arcTo(RectF(200f, 200f, 300f, 300f), 0f, 180f)
        // path.arcTo(oval,0,270,false);             // 与上面一句作用等价

        // 画出路径
        // path.arcTo(oval,0,270,false);             // 与上面一句作用等价

        // 画出路径
        canvas?.drawPath(path, paint)


    }
}