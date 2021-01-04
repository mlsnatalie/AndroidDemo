package com.example.androiddemo.jetPack

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.math.BigDecimal

/**
 * @author: mlsnatalie
 * @date: 2020/11/24 9:26 PM
 * @UpdateDate: 2020/11/24 9:26 PM
 * email：mlsnatalie@163.com
 * description：
 */
class MyFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mPriceListener: LiveData<BigDecimal> = StockLiveData("")
        mPriceListener.observe(viewLifecycleOwner, Observer<BigDecimal> { price: BigDecimal ->

        })
    }
}