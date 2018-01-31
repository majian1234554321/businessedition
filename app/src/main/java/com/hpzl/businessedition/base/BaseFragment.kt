package com.hpzl.businessedition.base


import android.content.Context
import android.support.v4.app.Fragment
import android.widget.Toast

/**
 *
 * @author admin
 * @date 2018/1/29
 */
abstract class BaseFragment : Fragment() {
    lateinit var mContext: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    fun <T> MutableList<T>.addElement(fragment: T): MutableList<T> {
        add(fragment)
        return this
    }

    fun toast(value: String) {
       Toast.makeText(mContext,value,Toast.LENGTH_SHORT).show()

    }
}