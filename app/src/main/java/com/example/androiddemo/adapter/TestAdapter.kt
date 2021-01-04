package com.example.androiddemo.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemo.R
import kotlinx.android.synthetic.main.item_new_organ_attention_view.view.*

/**
 * @author: mlsnatalie
 * @date: 2020/11/26 3:21 PM
 * @UpdateDate: 2020/11/26 3:21 PM
 * email：mlsnatalie@163.com
 * description：
 */
class TestAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mDataList: List<String?>? = listOf()
    private var stockListener: NewOrganAttentionClick? = null
    fun setListener(listener: NewOrganAttentionClick) {
        stockListener = listener
    }

    interface NewOrganAttentionClick {
        fun deleteSelfStock(market: String, code: String)
        fun addSelfStock()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_new_organ_attention_view, null))
    }

    override fun getItemCount(): Int {
        return mDataList?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bindData()
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindData() {
            itemView.tv_des.setOnClickListener {
                Log.e("aaaddd", ">>>tv_des")
            }
            itemView.stock_zdf_tv.setOnClickListener {
                Log.e("aaaddd", ">>>stock_zdf_tv")
            }
            itemView.stock_name_tv.setOnClickListener {
                Log.e("aaaddd", ">>>stock_name_tv")
            }
            itemView.stock_num.setOnClickListener {
                Log.e("aaaddd", ">>>stock_num")
            }
            itemView.add_self_tv.setOnClickListener {
                Log.e("aaaddd", ">>>add_self_tv")
            }
            itemView.layout_view_add_stock.setOnClickListener {
                Log.e("aaaddd", ">>>layout_view_add_stock")
            }

            itemView.setOnClickListener {
                Log.e("aaaddd", ">>>111111111")
            }

        }
    }

    fun refreshData(dataList: MutableList<String>) {
        mDataList = dataList
        notifyDataSetChanged()
    }

}