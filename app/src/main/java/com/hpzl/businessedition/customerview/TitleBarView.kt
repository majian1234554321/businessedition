package com.hpzl.businessedition.customerview

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.hpzl.businessedition.R

/**
 *
 * @author admin
 * @date 2018/1/30
 */
class TitleBarView : RelativeLayout {

    var title: TextView? = null

    constructor(context: Context?) : super(context) {
        initView(context)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView(context)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context)
    }

    private fun initView(context: Context?) {
        val view = View.inflate(context, R.layout.titlebarview, this)
        view.findViewById<ImageView>(R.id.iv).setOnClickListener {
            (context as Activity).finish()
        }

        title = view.findViewById<TextView>(R.id.title)
    }

    fun setTitle(value: String) {
        title?.text = value
    }
}