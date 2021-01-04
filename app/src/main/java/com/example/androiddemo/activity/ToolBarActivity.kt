package com.example.androiddemo.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemo.R
import kotlinx.android.synthetic.main.activity_toolbar.*
import kotlinx.android.synthetic.main.mytoolbar.*
import java.lang.Exception

/**
 * @author: mlsnatalie
 * @date: 2020/12/7 5:09 PM
 * @UpdateDate: 2020/12/7 5:09 PM
 * email：mlsnatalie@163.com
 * description：
 */
class ToolBarActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
//        callPhone()

    }

//    private fun callPhone() {
//        val intent = Intent(Intent.ACTION_CALL)
//        val data = Uri.parse("tel:" + "10086")
//        intent.data = data
//
//        try {
//            startActivity(intent)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }
}