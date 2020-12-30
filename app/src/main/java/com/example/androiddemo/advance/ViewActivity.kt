package com.example.androiddemo.advance

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator
import com.example.androiddemo.R
import kotlinx.android.synthetic.main.activity_self_view_test.*


/**
 * @author: mlsnatalie
 * @date: 2020/12/24 5:19 PM
 * @UpdateDate: 2020/12/24 5:19 PM
 * email：mlsnatalie@163.com
 * description：
 */
class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_self_view_test)
        //使用xml的方法写动画
//        layout_view_animation.animation = AnimationUtils.loadAnimation(this, R.anim.translate)

        //使用ObjectAnimator动画，view平移
        ObjectAnimator.ofFloat(layout_view_animation, "translationX", 0f, 300f).setDuration(1000)
            .start()
        changeTextColor()
    }

    /**
     * 动画改变字体颜色
     */
    @SuppressLint("RestrictedApi")
    private fun changeTextColor() {
        val objectAnimator: ObjectAnimator = ObjectAnimator.ofObject(
            tv_animation_color,
            "textColor",
            ArgbEvaluator(),
            -0x3311bc00,
            -0x34000000
        )
        objectAnimator.duration = 3000
        objectAnimator.repeatCount = Animation.INFINITE
        objectAnimator.repeatMode = ValueAnimator.REVERSE
        objectAnimator.start()
    }

}