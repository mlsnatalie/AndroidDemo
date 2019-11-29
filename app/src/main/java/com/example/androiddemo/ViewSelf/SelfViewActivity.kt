package com.example.androiddemo.ViewSelf

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.R
import kotlinx.android.synthetic.main.activity_self_view.*

/**
 * @author Menglingshuai
 * @date 2019-11-29.
 * email：mlsnatalie@163.com
 * description：
 */
class SelfViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_self_view)

        pay_bottom.onBuyViewClickListener = object : BuyBottomView.OnBuyViewClickListener {
            override fun onPayBtnClicked() {
                Toast.makeText(baseContext, "点击购买", Toast.LENGTH_SHORT).show()
            }

            override fun onFreeClicked() {
                Toast.makeText(baseContext, "免费购买", Toast.LENGTH_SHORT).show()
            }

        }
    }


}