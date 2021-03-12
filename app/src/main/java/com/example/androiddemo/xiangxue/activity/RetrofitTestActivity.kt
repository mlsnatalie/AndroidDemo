package com.example.androiddemo.xiangxue.activity

import android.os.Bundle
import android.util.Log
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.R
import com.example.androiddemo.http.HttpUtils
import com.example.androiddemo.xiangxue.api.WanAndroidApi
import com.example.androiddemo.xiangxue.utils.RxjavaUtils
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_retrofit_test.*

/**
 * @author: mlsnatalie
 * @date: 2021/3/9 6:52 PM
 * @UpdateDate: 2021/3/9 6:52 PM
 * email：mlsnatalie@163.com
 * description：
 */
public class RetrofitTestActivity : AppCompatActivity() {

    private val TAG = "RetrofitTestActivity"
    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_test)

        val wanAndroidApi = HttpUtils.getOnlineCookieRetrofit().create(WanAndroidApi::class.java)

        btn_project1.setOnClickListener {
            wanAndroidApi
                .project
                .compose(RxjavaUtils.io_main())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { project ->
                    Log.e("aaadddd", "project+$project")

                }
        }
        btn_project2.setOnClickListener {
            disposable = wanAndroidApi
                .getProjectItem(1, 294)
                .compose(RxjavaUtils.io_main())
                .subscribe { projectItem ->
                    Log.e("aaadddd", "projectItem+$projectItem")
                }
        }

        //网络请求嵌套
        //功能防抖

    }

    /**
     *
     */

    override fun onDestroy() {
        super.onDestroy()
        if (disposable != null) {
            disposable!!.dispose()
        }
    }
}