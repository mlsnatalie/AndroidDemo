package com.example.androiddemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androiddemo.ViewSelf.SelfViewActivity
import com.example.androiddemo.animation.AnimationActivity
import com.example.androiddemo.lambda.LambdaActivity
import com.example.androiddemo.matisseRxpermission.MatisseRxPermissionActivity
import com.example.androiddemo.rxjava.RxJavaActivity
import com.example.androiddemo.sp.SpActivity
import com.example.androiddemo.viewPager.FourActivity
import kotlinx.android.synthetic.main.activity_main_demo.*

class MainActivity : AppCompatActivity() {

    companion object {
        var mainActivity: MainActivity? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = MainActivity()
        setContentView(R.layout.activity_main_demo)
        initListener()
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
    }
}

