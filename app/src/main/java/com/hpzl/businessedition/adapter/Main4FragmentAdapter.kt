package com.hpzl.businessedition.adapter


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

import android.support.v4.app.FragmentStatePagerAdapter
import com.hpzl.businessedition.base.BaseFragment


/**
 *
 * @author admin
 * @date 2018/1/30
 */
class Main4FragmentAdapter(fm: FragmentManager?, val list: MutableList<BaseFragment>) : FragmentStatePagerAdapter(fm) {

    val array = arrayOf("待处理订单", "已完成订单", "套餐管理")

    override fun getItem(position: Int): Fragment = list[position]

    override fun getCount(): Int = list.size

    override fun getPageTitle(position: Int): CharSequence? {
        return array[position]
    }


}


