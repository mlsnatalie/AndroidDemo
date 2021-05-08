package com.example.androiddemo.xiangxue.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author: mlsnatalie
 * @date: 2021/5/8 1:59 PM
 * @UpdateDate: 2021/5/8 1:59 PM
 * email：mlsnatalie@163.com
 * description：
 */
class JetPackTestViewModel : ViewModel() {

    var title: MutableLiveData<String>? = null

    fun changeTitle(str: String) {
        title?.value = str
    }
}