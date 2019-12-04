package com.example.androiddemo.utils

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.WindowManager

/**
 * @author Menglingshuai
 * @date 2019-12-04.
 * email：mlsnatalie@163.com
 * description：与屏幕信息有关的类，包括屏幕的长宽、分辨率、长度换算
 */
class DisplayUtils {

    /**
     * 获取状态栏高度
     *
     * @return
     */
    fun getStatusBarHeight(context: Context): Int {
        var result = 0
        val resultId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resultId > 0) {
            result = context.resources.getDimensionPixelSize(resultId)
        }
        return result
    }

    /**
     * 获取屏幕分辨率
     * @param context
     * @return
     */
    fun getScreenDisplay(context: Context?): IntArray {
        if (context != null) {
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val width = windowManager.defaultDisplay.width // 手机屏幕的宽度
            val height = windowManager.defaultDisplay.height // 手机屏幕的高度
            return intArrayOf(width, height)
        }
        return intArrayOf(720, 1280)
    }

    /**
     * 获取屏幕的高度
     */
    fun getDisplayHeight(context: Context?): Int {
        if (context != null) {
            val dm = context.resources.displayMetrics
            val h_screen = dm.heightPixels
            return h_screen
        }

        return 1280
    }

    /**
     * 获取屏幕的宽度
     */
    fun getDisplayWidth(context: Context?): Int {
        if (context != null) {
            val dm = context.resources.displayMetrics
            val w_screen = dm.widthPixels
            return w_screen
        }
        return 720
    }

    /**
     * dp转px
     */
    fun Context.dp2px(dp: Float): Int {
//    val displayMetrics = resources.displayMetrics
//    return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()
    }

    /**
     * px转dp
     */
    fun Context.px2dp(px: Int): Float {
        val displayMetrics = resources.displayMetrics
        return px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)
    }

    fun Context.sp2px(sp: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
            sp, resources.displayMetrics).toInt()
    }

    fun Context.px2sp(px: Int): Float {
        return (px / resources.displayMetrics.scaledDensity)
    }
}