package com.example.androiddemo

import android.os.Build
import androidx.annotation.RequiresApi

import java.util.Comparator

/**
 * @author Menglingshuai
 * @date 2019-07-30.
 * email：mlsnatalie@163.com
 * description：
 */
object Test {
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
