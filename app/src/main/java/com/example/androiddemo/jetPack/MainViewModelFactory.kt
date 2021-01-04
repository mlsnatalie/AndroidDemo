package com.example.androiddemo.jetPack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @author: mlsnatalie
 * @date: 2020/11/24 6:34 PM
 * @UpdateDate: 2020/11/24 6:34 PM
 * email：mlsnatalie@163.com
 * description：
 */
class MainViewModelFactory(private val countReserved: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return JetPackViewModel() as T
    }
}