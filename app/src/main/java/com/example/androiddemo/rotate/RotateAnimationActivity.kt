package com.example.androiddemo.rotate

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.R
import kotlinx.android.synthetic.main.activity_rotate_animation.*


/**
 * @author: mlsnatalie
 * @date: 2020/10/30 5:44 PM
 * @UpdateDate: 2020/10/30 5:44 PM
 * email：mlsnatalie@163.com
 * description：
 */
class RotateAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotate_animation)
        val rotate = RotateAnimation(
            -90f,//其实位置的角度
            -70f,//终止位置的角度
            Animation.RELATIVE_TO_SELF,//相对于自身旋转
            0.5f,
            Animation.RELATIVE_TO_SELF,
            1.0f
        )
        val lin = LinearInterpolator()
        rotate.interpolator = lin
        rotate.duration = 2000 //设置动画持续周期

        rotate.repeatCount = 0 //设置重复次数

        rotate.fillAfter = true //动画执行完后是否停留在执行完的状态

        rotate.startOffset = 10 //执行前的等待时间

        iv_img_point.animation = rotate
    }
}