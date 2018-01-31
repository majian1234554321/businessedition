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
            textview.text = content[position].car_num
        }
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)


}