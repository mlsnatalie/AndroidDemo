package com.example.androiddemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androiddemo.R
import com.example.androiddemo.adapter.TestAdapter
import kotlinx.android.synthetic.main.activity_adapter.*
import kotlinx.android.synthetic.main.activity_jit_pack.*

/**
 * @author: mlsnatalie
 * @date: 2020/11/26 3:19 PM
 * @UpdateDate: 2020/11/26 3:19 PM
 * email：mlsnatalie@163.com
 * description：
 */
class JitPackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jit_pack)
        tv_jit_pack_view.showDiagnose()
    }
}