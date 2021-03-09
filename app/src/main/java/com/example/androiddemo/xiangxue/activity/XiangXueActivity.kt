package com.example.androiddemo.xiangxue.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.R
import com.example.androiddemo.http.HttpUtils
import com.example.androiddemo.xiangxue.api.WanAndroidApi
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_retrofit_test.*
import kotlinx.android.synthetic.main.activity_xiang_xue.*

/**
 * @author: mlsnatalie
 * @date: 2021/3/9 6:52 PM
 * @UpdateDate: 2021/3/9 6:52 PM
 * email：mlsnatalie@163.com
 * description：
 */
public class XiangXueActivity : AppCompatActivity() {

    private val TAG = "RetrofitTestActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xiang_xue)

        btn_retrofit.setOnClickListener { startActivity(Intent(this, RetrofitTestActivity::class.java)) }
    }
}