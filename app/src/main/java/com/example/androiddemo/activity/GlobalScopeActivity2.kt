package com.example.androiddemo.activity

import android.graphics.*
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.R
import kotlinx.android.synthetic.main.activity_global_scope.*
import kotlinx.android.synthetic.main.layout_remoteview.*
import kotlinx.coroutines.*
import retrofit2.Retrofit
import java.net.HttpURLConnection
import java.net.URL

/**
 * @author: mlsnatalie
 * @date: 2021/2/7 11:11 AM
 * @UpdateDate: 2021/2/7 11:11 AM
 * email：mlsnatalie@163.com
 * description：
 */
class GlobalScopeActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_global_scope)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://wanandroid.com")
            .build()

    }
}