package com.example.androiddemo.animation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.R
import kotlinx.android.synthetic.main.activity_wave.*

/**
 * @author Menglingshuai
 * @date 2019-12-04.
 * email：mlsnatalie@163.com
 * description：雷达水波扩散动画
 */
class WaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wave)
    }

    override fun onResume() {
        super.onResume()
        wave_circle?.startAnimation()
    }

    override fun onPause() {
        super.onPause()
        wave_circle?.pauseAnimation()
    }

    override fun onDestroy() {
        super.onDestroy()
        wave_circle?.stopAnimation()
    }
}