package com.hpzl.businessedition.views.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hpzl.businessedition.R
import com.hpzl.businessedition.adapter.Main1FragmentAdapter
import com.hpzl.businessedition.adapter.Main2FragmentAdapter
import com.hpzl.businessedition.base.BaseFragment
import kotlinx.android.synthetic.main.main2fragment.*

/**
 *
 * @author admin
 * @date 2018/1/30
 */
class Main2Fragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(mContext, R.layout.main2fragment, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = mutableListOf<BaseFragment>().addElement(Main2_1Fragment()).addElement(Main2_2Fragment()).addElement(Main2_3Fragment())

        viewpager.adapter = Main2FragmentAdapter(fragmentManager, list)
        tablayout.setupWithViewPager(viewpager)




    }
}