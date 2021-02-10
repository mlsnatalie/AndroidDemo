package com.example.androiddemo.activity

import android.graphics.*
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.R
import kotlinx.android.synthetic.main.activity_global_scope.*
import kotlinx.android.synthetic.main.layout_remoteview.*
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

/**
 * @author: mlsnatalie
 * @date: 2021/2/7 11:11 AM
 * @UpdateDate: 2021/2/7 11:11 AM
 * email：mlsnatalie@163.com
 * description：
 */
class GlobalScopeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_global_scope)
//        initGlobal()
        CoroutineScope(Dispatchers.Main).launch {
            val bitmap = getImageFromNetWork()
            val bitmapWithWaterMark = createWaterMark(bitmap, "谢小双")
            iv_image.setImageBitmap(bitmapWithWaterMark)
//            val bitmapWithWaterMark =
        }
    }

    private suspend fun getImageFromNetWork() = withContext(Dispatchers.IO) {
        val url = URL("https://wanandroid.com/blogimgs/8690f5f9-733a-476a-8ad2-2468d043c2d4.png")
        val connection = url.openConnection() as HttpURLConnection
        val inputStream = connection.inputStream
        BitmapFactory.decodeStream(inputStream)
    }

    /**
     * 水印
     */
    private suspend fun createWaterMark(bitmap: Bitmap, mark: String) = withContext(Dispatchers.IO) {
        val w = bitmap.width
        val h = bitmap.height
        val bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bmp)
        val paint = Paint()
        paint.color = Color.parseColor("#C5FF0000")
        paint.textSize = 150F
        paint.isAntiAlias = true
        canvas.drawBitmap(bitmap, 0f, 0f, paint)
        canvas.drawText(mark, 0f, (h / 2).toFloat(), paint)
        canvas.save()
        return@withContext bmp
    }

    private fun initGlobal() {
        GlobalScope.launch {// 在后台启动一个新的协程并继续
            delay(1000L)// 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
            Log.e("aaaddd", "hello world" + System.currentTimeMillis())
        }

        Log.e("aaaddd", "HELLO" + System.currentTimeMillis())
        Thread.sleep(2000L)
    }
}