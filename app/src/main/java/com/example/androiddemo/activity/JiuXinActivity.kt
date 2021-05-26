package com.example.androiddemo.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.androiddemo.R
import kotlinx.android.synthetic.main.activity_jiu_xin.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * @author: mlsnatalie
 * @date: 2021/5/26 3:31 下午
 * @UpdateDate: 2021/5/26 3:31 下午
 * email：mlsnatalie@163.com
 * description：
 */
class JiuXinActivity : AppCompatActivity() {

    val scope = MainScope()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jiu_xin)

        scope.launch {
            val one = async { getResult(10) }
            val two = async { getResult(20) }
            tv_title.text = one.await().toString() + two.await().toString()
        }

        lifecycleScope.launch {
            //创建一个协程Flow<T>
//            val a = Flow<T>
//            createFlow()
//            flow<> {
//
//            }.catch {
//
//            }.collect(
//
//            )
            val flow = (1..10).asFlow().flowOn(Dispatchers.Main)
            flow.collect {
                Log.e("aaaddd", it.toString())
            }
        }

        lifecycleScope.launch {
            val f = flow {
                for (i in 1..3) {
                    delay(500)
                    Log.e("TAG", "emit $i")
                    emit(i)
                }
            }
            withTimeoutOrNull(1600) {
                f.collect {
                    delay(500)
                    Log.e("TAG", "consume $it")
                }
            }
            Log.e("TAG", "cancel")
        }

    }

    private suspend fun getResult(num: Int): Int {
        delay(5000)
        return num * num
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}