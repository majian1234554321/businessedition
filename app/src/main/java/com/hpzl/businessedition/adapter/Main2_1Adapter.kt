package com.hpzl.businessedition.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hpzl.businessedition.R
import com.hpzl.businessedition.model.RoomTypeModel
import com.hpzl.businessedition.views.main.Main2_1Fragment
import com.hpzl.businessedition.views.main.Main2_1UpDateFragment
import com.hpzl.businessedition.views.main.MainFragment
import kotlinx.android.synthetic.main.main2_1adapter.view.*
import me.yokeyword.fragmentation.SupportFragment

/**
 *
 * @author admin
 * @date 2018/1/31
 */
class Main2_1Adapter(val context: Context, val content: MutableList<RoomTypeModel.ContentBean>, val main2_1Fragment: Main2_1Fragment) : RecyclerView.Adapter<Main2_1Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(View.inflate(context, R.layout.main2_1adapter, null))

    override fun getItemCount(): Int = content.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder?.itemView!!) {
            tv_housetype_name.text = "${content[position].name} (${content[position].mans}人) "
            tv_housetype_price.text = "${content[position].book_price} 元"
            iv_housetype.setImageResource(when (content[position].name) {
                "小包" -> {
                    R.drawable.icon_baoxiang
                }
                "中包" -> {
                    R.drawable.icon_baoxiang
                }
                "大包" -> {
                    R.drawable.icon_baoxiang
                }
                "VIP包" -> {
                    R.drawable.icon_vip
                }
                "卡座" -> {
                    R.drawable.icon_kazuo
                }
                "台位" -> {
                    R.drawable.icon_santai
                }
                else -> {
                    R.drawable.icon_baoxiang
                }
            })

            setOnClickListener {
                if (main2_1Fragment.parentFragment != null)
                    (main2_1Fragment.parentFragment!!.parentFragment as MainFragment).startBrotherFragment(Main2_1UpDateFragment.newInstance(content[position], position))
            }
        }
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)

}