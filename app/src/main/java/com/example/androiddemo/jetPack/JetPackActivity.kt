package com.example.androiddemo.jetPack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.androiddemo.R
import kotlinx.android.synthetic.main.activity_jetpack.*
import kotlinx.android.synthetic.main.activity_jetpack.view.*

/**
 * @author: mlsnatalie
 * @date: 2020/11/20 5:07 PM
 * @UpdateDate: 2020/11/20 5:07 PM
 * email：mlsnatalie@163.com
 * description：
 */
class JetPackActivity : AppCompatActivity() {

    private lateinit var viewModel: JetPackViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jetpack)
        viewModel = ViewModelProvider(this).get(viewModel::class.java)
        btn_plus.setOnClickListener { viewModel.count++ }
        refreshCounter()
    }

    private fun refreshCounter() {
        btn_plus.tv.text = viewModel.count.toString()

    }
}