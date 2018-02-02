package com.hpzl.businessedition.views.main

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hpzl.businessedition.R
import com.hpzl.businessedition.adapter.Main4FragmentAdapter
import com.hpzl.businessedition.base.BaseFragment
import kotlinx.android.synthetic.main.viewpager4fragment.*


import me.yokeyword.fragmentation.SupportFragment


/**
 * Created by YoKeyword on 16/6/5.
 */
class Main4Fragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.viewpager4fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tablayout.addTab(tablayout.newTab())
        tablayout.addTab(tablayout.newTab())
        tablayout.addTab(tablayout.newTab())

        val list = mutableListOf<BaseFragment>()

        list.add(Main4_1Fragment())
        list.add(Main4_2Fragment())
        list.add(Main4_3Fragment())



        viewpager.adapter = Main4FragmentAdapter(childFragmentManager, list)
        tablayout.setupWithViewPager(viewpager)
    }


    companion object {

        fun newInstance(): Main4Fragment {

            val args = Bundle()

            val fragment = Main4Fragment()
            fragment.arguments = args
            return fragment
        }
    }
}
