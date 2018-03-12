package com.hpzl.businessedition.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hpzl.businessedition.R
import com.hpzl.businessedition.model.DetailsModel
import kotlinx.android.synthetic.main.detailitemview.view.*

/**
 *
 * @author admin
 * @date 2018/2/5
 */
class Main1_DetailsAdapter(val mContext: Context, val array: MutableList<DetailsModel>) : RecyclerView.Adapter<Main1_DetailsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder = ViewHolder(View.inflate(mContext, R.layout.detailitemview, null))

    override fun getItemCount(): Int =array.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(holder?.itemView!!){
            tv_left.text = array[position].valueleft
            tv_right.text= array[position].valueright
            tv_right.setTextColor(array[position].color)
        }
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}