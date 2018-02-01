package com.hpzl.businessedition.base


import android.content.Context
import android.support.v4.app.Fragment
import android.widget.Toast

import com.hpzl.businessedition.views.main.Main1Fragment
import me.yokeyword.fragmentation.SupportFragment

/**
 *
 * @author admin
 * @date 2018/1/29
 */
abstract class BaseFragment : SupportFragment()  {
    lateinit var mContext: Context


    fun <T> MutableList<T>.addElement(fragment: T): MutableList<T> {
        add(fragment)
        return this
    }

    fun toast(value: String) {
        Toast.makeText(mContext, value, Toast.LENGTH_SHORT).show()

    }


    protected var _mBackToFirstListener: OnBackToFirstListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        if (context is OnBackToFirstListener) {
            _mBackToFirstListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnBackToFirstListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        _mBackToFirstListener = null
    }

    /**
     * 处理回退事件
     *
     * @return
     */
    override fun onBackPressedSupport(): Boolean {
        if (childFragmentManager.backStackEntryCount > 1) {
            popChild()
        } else {
            if (this is Main1Fragment) {   // 如果是 第一个Fragment 则退出app
                _mActivity.finish()
            } else {                                    // 如果不是,则回到第一个Fragment
                _mBackToFirstListener!!.onBackToFirstFragment()
            }
        }
        return true
    }

    interface OnBackToFirstListener {
        fun onBackToFirstFragment()
    }
}