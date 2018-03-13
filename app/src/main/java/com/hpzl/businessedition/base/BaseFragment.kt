package com.hpzl.businessedition.base


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast

import com.hpzl.businessedition.views.main.Main1Fragment
import me.yokeyword.fragmentation.SupportFragment

/**
 *
 * @author admin
 * @date 2018/1/29
 */
abstract class BaseFragment : SupportFragment()  {
    lateinit var mContext: Activity


    fun <T> MutableList<T>.addElement(fragment: T): MutableList<T> {
        add(fragment)
        return this
    }

    fun toast(value: String) {
        Toast.makeText(mContext, value, Toast.LENGTH_SHORT).show()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext =  activity as Activity

    }


}