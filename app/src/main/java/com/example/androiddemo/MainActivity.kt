package com.example.androiddemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.example.androiddemo.ViewSelf.SelfViewActivity
import com.example.androiddemo.animation.AnimationActivity
import com.example.androiddemo.circle.CirCleActivity
import com.example.androiddemo.coordinatorLayout.CoordinatorLayoutActivity
import com.example.androiddemo.draw.DrawActivity
import com.example.androiddemo.edittext.EditTextActivity
import com.example.androiddemo.fragment.NewFragmentActivity
import com.example.androiddemo.lambda.LambdaActivity
import com.example.androiddemo.matisseRxpermission.MatisseRxPermissionActivity
import com.example.androiddemo.okhttp.OkhttpActivity
import com.example.androiddemo.rotate.RotateAnimationActivity
import com.example.androiddemo.rxjava.RxJavaActivity
import com.example.androiddemo.sp.SpActivity
import com.example.androiddemo.utils.ObservableScrollView
import com.example.androiddemo.utils.ObservableScrollView.OnScrollStatusListener
import com.example.androiddemo.viewPager.FourActivity
import kotlinx.android.synthetic.main.activity_main_demo.*
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        var mainActivity: MainActivity? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = MainActivity()
        setContentView(R.layout.activity_main_demo)
        initListener()
        initScrollView()

    }

    private fun initListener() {
        btn_lambda.setOnClickListener {
            startActivity(Intent(this, LambdaActivity::class.java))
        }
        btn_sp.setOnClickListener {
            startActivity(Intent(this, SpActivity::class.java))
        }
        btn_recyclerView_move.setOnClickListener {

        }
        btn_viewpager.setOnClickListener {
            startActivity(Intent(this, FourActivity::class.java))
        }
        btn_rx_java.setOnClickListener {
            startActivity(Intent(this, RxJavaActivity::class.java))
        }
        btn_Matisse_rxPermission.setOnClickListener {
            startActivity(Intent(this, MatisseRxPermissionActivity::class.java))
        }
        view_self?.setOnClickListener {
            startActivity(Intent(this, SelfViewActivity::class.java))
        }
        btn_animation?.setOnClickListener {
            startActivity(Intent(this, AnimationActivity::class.java))
        }
        btn_CoordinatorLayout?.setOnClickListener {
            startActivity(Intent(this, CoordinatorLayoutActivity::class.java))
        }
        btn_fragment.setOnClickListener {
            startActivity(Intent(this, NewFragmentActivity::class.java))
        }
        btn_edit_text.setOnClickListener {
            startActivity(Intent(this, EditTextActivity::class.java))
        }
        btn_draw.setOnClickListener {
            startActivity(Intent(this, DrawActivity::class.java))
        }
        btn_draw_support.setOnClickListener {

        }

        btn_draw_circle.setOnClickListener {
            startActivity(Intent(this, CirCleActivity::class.java))
        }
        btn_rotate_animation.setOnClickListener {
            startActivity(Intent(this, RotateAnimationActivity::class.java))
        }
        btn_okhttp.setOnClickListener {
            startActivity(Intent(this, OkhttpActivity::class.java))
        }
    }

    private fun initScrollView() {
        scroll_view.setOnScrollStatusListener(object : OnScrollStatusListener {
            override fun onScrolling() {
                Log.e("aaaddd", "滑动")
            }

            override fun onScrollStop() {
                Log.e("aaaddd", "停止滑动")
            }
        })
    }
}

