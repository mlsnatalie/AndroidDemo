package com.example.androiddemo.ViewSelf

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.androiddemo.R
import kotlinx.android.synthetic.main.widget_album_buy_layout.view.*

/**
 * @author Menglingshuai
 * @date 2019-11-29.
 * email：mlsnatalie@163.com
 * description：
 */
class BuyBottomView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var isHaveFreeVideo = false

    private var purchasable = false
    private var isHavePromotion = false


    var onBuyViewClickListener: OnBuyViewClickListener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.widget_album_buy_layout, this)

        have_free_video_pay_layout.setOnClickListener { onBuyViewClickListener?.onFreeClicked() }
        promotion_main_layout.setOnClickListener { onBuyViewClickListener?.onPayBtnClicked() }
    }

    interface OnBuyViewClickListener {
        fun onPayBtnClicked()
        fun onFreeClicked()
    }
}