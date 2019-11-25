package com.example.androiddemo.matisseRxpermission

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.R
import com.tbruyelle.rxpermissions2.RxPermissions
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import io.reactivex.observers.DisposableObserver
import com.zhihu.matisse.engine.impl.GlideEngine
import com.zhihu.matisse.internal.entity.CaptureStrategy
import kotlinx.android.synthetic.main.activity_matisse_main.*


/**
 * @author Menglingshuai
 * @date 2019-09-09.
 * email：mlsnatalie@163.com
 * description：重新设计了相册的布局，有这个需求的时候可以用到。
 */
class MatisseRxPermissionActivity : AppCompatActivity() {

    private val REQUEST_CODE_CHOOSE = 23

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matisse_main)
        initPermission()
        initView()
    }

    private fun initPermission() {
        RxPermissions(this)
            .request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .subscribe(object : DisposableObserver<Boolean>() {
                override fun onComplete() {

                }

                override fun onNext(t: Boolean) {
                }

                override fun onError(e: Throwable) {
                }

            })
    }

    private fun initView() {
        btn_matisse.setOnClickListener {
//            Matisse.from(this)
//                .choose(MimeType.ofAll(), true)
//                .setPreviewEnable(false, false)
//                .showSingleMediaType(true)
//                .countable(true)
//                .maxSelectablePerMediaType(11, 1)
//                .minSelectablePerMediaType(3, 1)
//                .spanCount(4)
//                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
//                .thumbnailScale(0.85f)
//                .maxOriginalSize(10)
//                .forResult(100)

            Matisse.from(this)
                .choose(MimeType.allOf()) //照片视频全部显示
                .countable(true) //有序选择图片
                .maxSelectable(9) //最大选择数量为9
                .capture(true) //图片显示表格的大小getResources()
                .captureStrategy(CaptureStrategy(true, "com.example.androiddemo.fileprovider")) //
//                .addFilter(GifSizeFilter(320, 320, 5 * Filter.K * Filter.K)) //过滤器
                .gridExpectedSize(resources.getDimensionPixelSize(R.dimen.grid_expected_size_main)) //图片显示表格的大小getResources()
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) //图像选择和预览活动所需的方向。
                .thumbnailScale(0.85f) //缩放比例
                .imageEngine(MyGlideEngine()) //图片加载方式
                .forResult(REQUEST_CODE_CHOOSE) //请求码
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == Activity.RESULT_OK) {
//            mAdapter.setData(Matisse.obtainResult(data!!), Matisse.obtainPathResult(data))
//            Log.e("OnActivityResult ", String.valueOf(Matisse.obtainOriginalState(data)))

            val result = Matisse.obtainResult(data)
            tv_result.text = result.toString()
        }
    }

}