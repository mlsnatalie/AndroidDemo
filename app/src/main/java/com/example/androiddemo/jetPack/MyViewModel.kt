package com.example.androiddemo.jetPack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author: mlsnatalie
 * @date: 2020/11/6 5:24 PM
 * @UpdateDate: 2020/11/6 5:24 PM
 * email：mlsnatalie@163.com
 * description：
 */
class MyViewModel : ViewModel() {

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private val users: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>().also {

        }
    }

//    fun getUsers(): LiveData<List<User>> {
//        return User()
//    }
}