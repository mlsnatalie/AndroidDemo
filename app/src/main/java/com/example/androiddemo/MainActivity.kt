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

        var list: ArrayList<String>? = null
        var list1: ArrayList<String>? = null
        list = ArrayList()
        list1 = ArrayList()
        for (i in 0..1000) {
            list.add("test$i")
            list1.add("test" + (i * 2))
        }
        System.out.println(checkDiffrent(list, list1))
    }

    private fun initListener() {
        btn_lambda.setOnClickListener {
            startActivity(Intent(this, LambdaActivity::class.java))
        }
        btn_sp.setOnClickListener {
            startActivity(Intent(this, SpActivity::class.java))
        }
    }

    private fun checkDiffrent(list: List<String>, list1: List<String>): Boolean {

        if (list.size != list1.size) {
            return false
        }
        for (str in list) {
            if (!list1.contains(str)) {
                return false
            }
        }
        return true
    }
}

