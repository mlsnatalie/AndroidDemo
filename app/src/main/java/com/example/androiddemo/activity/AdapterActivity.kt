package com.example.androiddemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androiddemo.R
import com.example.androiddemo.adapter.TestAdapter
import kotlinx.android.synthetic.main.activity_adapter.*

/**
 * @author: mlsnatalie
 * @date: 2020/11/26 3:19 PM
 * @UpdateDate: 2020/11/26 3:19 PM
 * email：mlsnatalie@163.com
 * description：
 */
class AdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter)

        var dataList: MutableList<String> = mutableListOf("1", "2", "3")
//        for (i in 0..3) {
//            dataList[i] = (i).toString()
//        }
        val manager = GridLayoutManager(this, 3)
        rv_recyclerView.layoutManager = manager
        val adapter = TestAdapter()
        rv_recyclerView.adapter = adapter
        adapter.refreshData(dataList)
    }
}