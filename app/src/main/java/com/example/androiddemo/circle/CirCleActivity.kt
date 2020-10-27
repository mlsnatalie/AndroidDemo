package com.example.androiddemo.circle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.R
import kotlinx.android.synthetic.main.activity_circle.*

/**
 * @author: mlsnatalie
 * @date: 2020/10/27 8:48 PM
 * @UpdateDate: 2020/10/27 8:48 PM
 * email：mlsnatalie@163.com
 * description：
 */
class CirCleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle)
        circle.setModel(CircleView.CircleModel.MODEL_DETAIL)
        circle.setScore(80)
    }
}