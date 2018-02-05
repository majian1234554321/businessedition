package com.hpzl.businessedition.customerview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.hpzl.businessedition.R

/**
 *
 * @author admin
 * @date 2018/2/5
 */
class DetailItemView : RelativeLayout {
    constructor(context: Context?) : super(context) {
        initView(context)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView(context)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context)
    }

    val tv_left: TextView? = null
    val tv_right: TextView? = null

    private fun initView(context: Context?) {
        val view = View.inflate(context, R.layout.detailitemview, this)
        val tv_left = view.findViewById<TextView>(R.id.tv_left)
        val tv_right = view.findViewById<TextView>(R.id.tv_right)
    }

    fun setleftTitle(value: String) {
        tv_left?.text = value
    }

    fun setRightVlaue(value: String, colorValue: Int) {
        tv_right?.text = value
        tv_right?.setTextColor(colorValue)
    }

}