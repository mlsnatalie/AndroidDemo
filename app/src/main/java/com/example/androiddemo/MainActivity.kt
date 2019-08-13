package com.example.androiddemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androiddemo.lambda.LambdaActivity
import com.example.androiddemo.sp.SpActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        var mainActivity: MainActivity? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val activity: MainActivity
        super.onCreate(savedInstanceState)
        mainActivity = MainActivity()
        setContentView(R.layout.activity_main)
        initListener()

    }

    private fun initListener() {
        btn_lambda.setOnClickListener {
            startActivity(Intent(this, LambdaActivity::class.java))
        }
        btn_sp.setOnClickListener {
            startActivity(Intent(this, SpActivity::class.java))
        }
        btn_recyclerView_move.setOnClickListener {

        }
    }

}

