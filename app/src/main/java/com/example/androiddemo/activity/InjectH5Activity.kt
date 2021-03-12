package com.example.androiddemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.R
import kotlinx.android.synthetic.main.activity_inject_h5.*

/**
 * @author: mlsnatalie
 * @date: 2021/3/12 1:57 PM
 * @UpdateDate: 2021/3/12 1:57 PM
 * email：mlsnatalie@163.com
 * description：
 */
class InjectH5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inject_h5)
        //允许JavaScript执行
        //找到Html文件，也可以用网络上的文件
        //webview，也可以用网络上的文件
        webview.loadUrl("file:///android_asset/index.html")
        //添加一个对象, 让JS可以访问该对象的方法, 该对象中可以调用JS中的方法
        //添加一个对象, 让JS可以访问该对象的方法, 该对象中可以调用JS中的方法
//        webview.addJavascriptInterface(this, "contact")
    }
}