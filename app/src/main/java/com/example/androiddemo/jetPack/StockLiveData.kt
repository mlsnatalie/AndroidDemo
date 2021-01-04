package com.example.androiddemo.jetPack

import androidx.lifecycle.LiveData
import java.math.BigDecimal

/**
 * @author: mlsnatalie
 * @date: 2020/11/24 9:23 PM
 * @UpdateDate: 2020/11/24 9:23 PM
 * email：mlsnatalie@163.com
 * description：
 */
class StockLiveData(symbol: String) : LiveData<BigDecimal>() {

    private val stockManager = StockManager(symbol)

    private val listener = { price: BigDecimal ->
        value = price
    }

    override fun onActive() {
        stockManager.requestPriceUpdates(listener)
    }

    override fun onInactive() {
        stockManager.removeUpdates(listener)
    }
}