package com.example.androiddemo.advance

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import butterknife.OnClick
import com.example.androiddemo.R
import com.example.androiddemo.coordinatorLayout.CoordinatorLayoutActivity
import kotlinx.android.synthetic.main.activity_advance.*

/**
 * @author: mlsnatalie
 * @date: 2020/12/24 5:15 PM
 * @UpdateDate: 2020/12/24 5:15 PM
 * email：mlsnatalie@163.com
 * description：
 */
class AdvanceActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advance)
        btn_CoordinatorLayout.setOnClickListener(this)
        btn_self_view.setOnClickListener(this)
    }

//    @OnClick(R.id.btn_CoordinatorLayout, R.id.btn_self_view)
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_CoordinatorLayout -> {
                startActivity(Intent(this, CoordinatorLayoutActivity::class.java))
            }
            R.id.btn_self_view -> {
                startActivity(Intent(this, ViewActivity::class.java))
            }

        }

    }
}