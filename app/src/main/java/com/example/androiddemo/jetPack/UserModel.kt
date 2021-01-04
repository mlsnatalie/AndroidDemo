package com.example.androiddemo.jetPack

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author: mlsnatalie
 * @date: 2020/11/24 8:37 PM
 * @UpdateDate: 2020/11/24 8:37 PM
 * email：mlsnatalie@163.com
 * description：
 */
class UserModel : ViewModel() {

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        currentName.value = "zzz"
    }

}