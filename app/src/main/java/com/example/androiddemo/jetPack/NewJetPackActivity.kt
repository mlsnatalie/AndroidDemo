package com.example.androiddemo.jetPack

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androiddemo.R
import com.example.androiddemo.databinding.ActivityNewJetpackBinding

/**
 * @author: mlsnatalie
 * @date: 2020/11/24 7:58 PM
 * @UpdateDate: 2020/11/24 7:58 PM
 * email：mlsnatalie@163.com
 * description：
 */
class NewJetPackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_new_jetpack)

        val binding: ActivityNewJetpackBinding = DataBindingUtil.setContentView(this, R.layout.activity_new_jetpack)
        binding.user = User("xys", "")
    }
}