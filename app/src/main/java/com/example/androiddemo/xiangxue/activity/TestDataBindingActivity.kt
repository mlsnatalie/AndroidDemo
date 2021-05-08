package com.example.androiddemo.xiangxue.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androiddemo.R
import com.example.androiddemo.databinding.ActivityLayoutJetpackBinding
import com.example.androiddemo.jetPack.UserModel

/**
 * @author: mlsnatalie
 * @date: 2021/5/8 2:52 PM
 * @UpdateDate: 2021/5/8 2:52 PM
 * email：mlsnatalie@163.com
 * description：
 */
class TestDataBindingActivity : AppCompatActivity() {
    private var binding: ActivityLayoutJetpackBinding? = null
    private val jetPackTestViewModel: JetPackTestDemoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_layout_jetpack
        )
//        jetPackTestViewModel = ViewModelProvider(
//            this,
//            ViewModelProvider.AndroidViewModelFactory(this.application)
//        ).get(
//            JetPackTestDemoViewModel::class.java
//        )
    binding?.vm = jetPackTestViewModel
    binding?.lifecycleOwner = this
    }
}