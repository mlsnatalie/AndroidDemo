package com.example.androiddemo.xiangxue.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author: mlsnatalie
 * @date: 2021/5/8 3:10 PM
 * @UpdateDate: 2021/5/8 3:10 PM
 * email：mlsnatalie@163.com
 * description：
 */
class JetPackTestDemoViewModel : ViewModel() {
    private var title: MutableLiveData<String>? = null
    val currentTitle: MutableLiveData<String>
        get() {
            if (title == null) {
                title = MutableLiveData()
                title!!.value = ""
            }
            return title!!
        }

    fun changeTitle(title: MutableLiveData<String>?) {
        this.title = title
    }
}