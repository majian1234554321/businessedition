package com.hpzl.businessedition.views.main

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hpzl.businessedition.R
import com.hpzl.businessedition.adapter.Main1FragmentAdapter
import com.hpzl.businessedition.base.BaseFragment
import kotlinx.android.synthetic.main.main1fragment.*
import android.support.design.widget.TabLayout
import com.hpzl.businessedition.customerview.TabTitle
import com.hpzl.businessedition.iview.Main1View
import com.hpzl.businessedition.model.ReserveTopModel
import com.hpzl.businessedition.presenter.Main1Present
import com.hpzl.businessedition.utils.SPUtils


/**
 *
 * @author admin
 * @date 2018/1/30
 */
class Main1Fragment : BaseFragment(), View.OnClickListener, Main1View {
    override fun setReserveTopData(t: ReserveTopModel) {
        val value = arrayOf(t.content.waiteQueue, t.content.waiteOrder, t.content.noArrive, t.content.orderDone)
        titles.forEachIndexed { index, s ->
            val tab = tablayout.getTabAt(index)//获得每一个tab
            TabTitle(mContext)
            val tabTitle = TabTitle(mContext)
            tab?.customView = tabTitle
            if (index == 0) tabTitle.setchecked(true)
            tabTitle.setValue(s, value[index])
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_qrScan -> {
            }
            R.id.tv_search -> {
            }
            else -> {
            }
        }
    }

    private val titles = arrayOf("待处理", "已预订", "取消", "消费")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(mContext, R.layout.main1fragment, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val list = mutableListOf<BaseFragment>().addElement(Main1_1Fragment()).addElement(Main1_2Fragment()).addElement(Main1_3Fragment()).addElement(Main1_4Fragment())

        viewpager.adapter = Main1FragmentAdapter(fragmentManager, list)
        tablayout.setupWithViewPager(viewpager)

        iv_qrScan.setOnClickListener(this)
        tv_search.setOnClickListener(this)
        var main1Present = Main1Present(this)
        main1Present.getTopcount(SPUtils.getString("token", "-1"))







        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                (tab.customView as TabTitle).setchecked(true)
                viewpager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                (tab.customView as TabTitle).setchecked(false)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

    }
}