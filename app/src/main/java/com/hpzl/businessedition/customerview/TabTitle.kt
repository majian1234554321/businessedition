package com.hpzl.businessedition.customerview


import android.content.Context
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.hpzl.businessedition.R


/**
 *
 * @author admin
 * @date 2018/1/30
 */
class TabTitle : RelativeLayout {
    var textView: TextView? = null
    var tv_circle: TextView? = null

    constructor(context: Context?) : super(context) {
        intView(context)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        intView(context)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        intView(context)
    }

    private fun intView(context: Context?) {
        val view = View.inflate(context, R.layout.tabtitle, this)
        textView = view.findViewById<TextView>(R.id.title)
        tv_circle = view.findViewById<TextView>(R.id.tv_circle)
    }

    fun setchecked(flag: Boolean) {
        if (flag) {
            textView?.setTextColor(Color.parseColor("#C4483C"))
            tv_circle?.setBackgroundResource(R.drawable.titlecircle)
        } else {
            textView?.setTextColor(Color.parseColor("#4a4a4a"))
            tv_circle?.setBackgroundResource(R.drawable.titlecircleun)
        }
    }

    fun setValue(value: String, value2: String) {
        textView?.text = value
        if (!TextUtils.isEmpty(value2)) {
            tv_circle?.visibility = View.VISIBLE
            tv_circle?.text = value2
        } else tv_circle?.visibility = View.GONE
    }


}