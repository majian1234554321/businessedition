package com.hpzl.businessedition.views.main

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hpzl.businessedition.R
import com.hpzl.businessedition.adapter.Main2FragmentAdapter
import com.hpzl.businessedition.adapter.Main3FragmentAdapter
import com.hpzl.businessedition.base.BaseFragment
import kotlinx.android.synthetic.main.viewpager3fragment.*

import me.yokeyword.fragmentation.SupportFragment


/**
 * Created by YoKeyword on 16/6/5.
 */
class ViewPager3Fragment : SupportFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.viewpager3fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tablayout.addTab(tablayout.newTab())
        tablayout.addTab(tablayout.newTab())
        tablayout.addTab(tablayout.newTab())

        val list = mutableListOf<BaseFragment>()

        list.add(Main3_1Fragment())
        list.add(Main3_2Fragment())
        list.add(Main3_3Fragment())



        viewpager.adapter = Main3FragmentAdapter(childFragmentManager, list)
        tablayout.setupWithViewPager(viewpager)
    }


    companion object {
        fun newInstance(): ViewPager3Fragment {
            val args = Bundle()

            val fragment = ViewPager3Fragment()
            fragment.arguments = args
            return fragment
        }
    }
}
