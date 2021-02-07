package com.example.androiddemo.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
        initGlobal()
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