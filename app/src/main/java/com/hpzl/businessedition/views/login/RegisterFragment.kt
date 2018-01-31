package com.hpzl.businessedition.views.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hpzl.businessedition.base.BaseFragment

/**
 *
 * @author admin
 * @date 2018/1/29
 */
class RegisterFragment : BaseFragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val  textView =  TextView(inflater.context)
        textView.text = "222"
        return textView
    }
}