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
class Main2FragmentAdapter(fm: FragmentManager?, val list: MutableList<BaseFragment>) : FragmentStatePagerAdapter(fm) {

    val array = arrayOf("房型管理", "已预订", "取消")

    override fun getItem(position: Int): Fragment = list[position]

    override fun getCount(): Int = list.size

    override fun getPageTitle(position: Int): CharSequence? {
        return array[position]
    }


}


