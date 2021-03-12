package com.example.androiddemo.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.R
import com.example.androiddemo.ViewSelf.SelfViewActivity
import com.example.androiddemo.advance.AdvanceActivity
import com.example.androiddemo.animation.AnimationActivity
import com.example.androiddemo.circle.CirCleActivity
import com.example.androiddemo.coordinatorLayout.CoordinatorLayoutActivity
import com.example.androiddemo.draw.DrawActivity
import com.example.androiddemo.edittext.EditTextActivity
import com.example.androiddemo.fragment.NewFragmentActivity
import com.example.androiddemo.jetPack.NewJetPackActivity
import com.example.androiddemo.lambda.LambdaActivity
import com.example.androiddemo.matisseRxpermission.MatisseRxPermissionActivity
import com.example.androiddemo.okhttp.OkhttpActivity
import com.example.androiddemo.rotate.RotateAnimationActivity
import com.example.androiddemo.rxjava.NRxjavaActivity
import com.example.androiddemo.sp.SpActivity
import com.example.androiddemo.utils.ObservableScrollView
import com.example.androiddemo.viewPager.FourActivity
import com.example.androiddemo.xiangxue.activity.XiangXueActivity
import kotlinx.android.synthetic.main.activity_main_demo.*
import kotlinx.android.synthetic.main.activity_main_demo.btn_room
import kotlinx.android.synthetic.main.activity_main_demo.scroll_view
import kotlinx.android.synthetic.main.activity_normal_demo.*

/**
 * @author: mlsnatalie
 * @date: 2021/3/12 10:48 AM
 * @UpdateDate: 2021/3/12 10:48 AM
 * email：mlsnatalie@163.com
 * description：
 */
class NormalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_demo)
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
            startActivity(Intent(this, NRxjavaActivity::class.java))
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
        btn_jetPack.setOnClickListener {
            startActivity(Intent(this, NewJetPackActivity::class.java))
        }
        btn_remoteViews_notification.setOnClickListener { startActivity((Intent(this, AdapterActivity::class.java))) }
        btn_toolbar.setOnClickListener { startActivity(Intent(this, ToolBarActivity::class.java)) }
        btn_up_down_bal.setOnClickListener { startActivity(Intent(this, UpDownBalActivity::class.java)) }
        btn_advance.setOnClickListener { startActivity(Intent(this, AdvanceActivity::class.java)) }
        btn_jit_pack.setOnClickListener { startActivity(Intent(this, JitPackActivity::class.java)) }
        btn_room.setOnClickListener { startActivity(Intent(this, XiangXueActivity::class.java)) }
        btn_inject_h5.setOnClickListener { startActivity(Intent(this, InjectH5Activity::class.java)) }
    }

    private fun initScrollView() {
        scroll_view.setOnScrollStatusListener(object : ObservableScrollView.OnScrollStatusListener {
            override fun onScrolling() {
                Log.e("aaaddd", "滑动")
            }

            override fun onScrollStop() {
                Log.e("aaaddd", "停止滑动")
            }
        })
    }
}