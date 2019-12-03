package com.example.androiddemo.animation

import android.animation.*
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.R
import kotlinx.android.synthetic.main.activity_animation.*


/**
 * @author Menglingshuai
 * @date 2019-12-02.
 * email：mlsnatalie@163.com
 * description：
 */
class AnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        btn_start_animation.setOnClickListener {
            anim7()
        }
    }

    private fun anim1() {
        val anim = ValueAnimator.ofFloat(0f, 1f)
        anim.duration = 3000L
        anim.addUpdateListener {
            val currentValue = it.animatedValue
            Log.e("aaaddd", "currentValue+++$currentValue")
        }
        anim.start()
    }

    private fun anim2() {
        val anim = ObjectAnimator.ofFloat(tv_text, "alpha", 1f, 0f, 1f)
        anim.duration = 5000L
        anim.start()
    }

    private fun anim3() {
        val anim = ObjectAnimator.ofFloat(tv_text, "rotation", 0f, 360f)
        anim.duration = 3000L
        anim.start()
    }

    private fun anim4() {
        val curTranslationX = tv_text.translationX
        val animator = ObjectAnimator.ofFloat(
            tv_text,
            "translationX",
            curTranslationX,
            -500f,
            curTranslationX
        )
        animator.duration = 5000
        animator.start()
    }

    private fun anim5() {
        val animator = ObjectAnimator.ofFloat(tv_text, "scaleY", 1f, 3f, 1f)
        animator.duration = 5000
        animator.start()

        /**
         * 动画的监听器
         */
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {

            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {

            }

            override fun onAnimationStart(animation: Animator?, isReverse: Boolean) {

            }

            override fun onAnimationPause(animation: Animator?) {

            }
        })

        /**
         * 完全实现动画的监听器，比较复杂，不建议使用，使用上面的适配器模式来监听
         */
        animator.addListener(object : Animation.AnimationListener, Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

        })
    }

    /**
     * 实现组合动画功能主要需要借助AnimatorSet这个类，这个类提供了一个play()方法，如果我们向这个方法中传入一个Animator对象(ValueAnimator或ObjectAnimator)将会返回一个AnimatorSet.Builder的实例，AnimatorSet.Builder中包括以下四个方法：

     * after(Animator anim)   将现有动画插入到传入的动画之后执行
        after(long delay)   将现有动画延迟指定毫秒后执行
        before(Animator anim)   将现有动画插入到传入的动画之前执行
        with(Animator anim)   将现有动画和传入的动画同时执行
        好的，有了这四个方法，我们就可以完成组合动画的逻辑了，那么比如说我们想要让TextView先从屏幕外移动进屏幕，然后开始旋转360度，旋转的同时进行淡入淡出操作，就可以这样写：
     */
    private fun anim6() {
        val moveIn = ObjectAnimator.ofFloat(tv_text, "translationX", -500f, 0f)
        val rotate = ObjectAnimator.ofFloat(tv_text, "rotation", 0f, 360f)
        val fadeInOut = ObjectAnimator.ofFloat(tv_text, "alpha", 1f, 0f, 1f)
        val animSet = AnimatorSet()
        animSet.play(rotate).with(fadeInOut).after(moveIn)
        animSet.duration = 5000
        animSet.start()
    }

    private fun anim7() {
        tv_text.animate().x(500f).y(500f).alpha(0f).setDuration(5000L).translationX(500f).translationY(500f).rotation(360f)
            .interpolator = BounceInterpolator()
    }
}