package com.hpzl.businessedition.customerview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.hpzl.businessedition.R
import org.w3c.dom.Text

/**
 *
 * @author admin
 * @date 2018/1/30
 */
class LineEditTextView : RelativeLayout {

    var leftTitle: TextView? = null
    var rightTitle: TextView? = null

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
        val view = View.inflate(context, R.layout.lineedittextview, this)
        leftTitle = view.findViewById<TextView>(R.id.leftTitle)
        rightTitle = view.findViewById<TextView>(R.id.rightTitle)
    }

    fun setValues(value: String,value2: String) {
        leftTitle?.text = value
        rightTitle?.hint = value2
    }

    fun getRightTitle(): String {
        return rightTitle?.text?.trim().toString()
    }
}