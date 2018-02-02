package com.hpzl.businessedition.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hpzl.businessedition.R
import com.hpzl.businessedition.model.ReserveMainModel

import kotlinx.android.synthetic.main.main1_1fragmentadapter.view.*


/**
 *
 * @author admin
 * @date 2018/1/30
 */
class Main1_1234Adapter(val context: Context, val content: Array<ReserveMainModel.ContentBean>) : RecyclerView.Adapter<Main1_1234Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder = ViewHolder(View.inflate(context, R.layout.main1_1fragmentadapter, null))

    override fun getItemCount(): Int = content.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(holder?.itemView!!) {
            tv_payStatus.text = when (content[position].pay_method) {

                "0" -> {
                    "正在消费"
                }

                "3" -> {
                    "已消费"
                }
                else -> {
                    "未知" + content[position].pay_method
                }
            }


            tv1.text = "姓名: ${content[position].nickname}"
            tv2.text = "电话: ${content[position].mobile}"
            tv3.text = "宾客: ${content[position].people_num}"
            tv4.text = "房型: ${content[position].name}"
            tv5.text = "车位: ${content[position].car_num}"
            tv6.text = "房号: ${content[position].number}"
            tv7.text = "预留时间: ${content[position].nickname}"
            tv8.text = "订金: ${content[position].nickname}"
            tv9.text = "下单时间: ${content[position].nickname}"
            tv10.text = "消费: ${content[position].display_balance}"
        }
    }

    fun addData(value: Array<ReserveMainModel.ContentBean>) {
        content.plus(value)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)


}