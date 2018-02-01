package com.hpzl.businessedition.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hpzl.businessedition.R
import com.hpzl.businessedition.model.RoomTypeModel
import kotlinx.android.synthetic.main.main2_1adapter.view.*

/**
 *
 * @author admin
 * @date 2018/1/31
 */
class Main2_1Adapter(val context: Context, val content: MutableList<RoomTypeModel.ContentBean>) : RecyclerView.Adapter<Main2_1Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder = ViewHolder(View.inflate(context, R.layout.main2_1adapter, null))

    override fun getItemCount(): Int = content.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(holder?.itemView!!) {
            tv_left.text = "${content[position].name} (${content[position].mans}人) "
            tv_right.text = "${content[position].book_price} 元"
        }
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {


    }

}