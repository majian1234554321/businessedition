package com.hpzl.businessedition.views.main

import android.os.Bundle
import android.support.design.widget.TabLayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hpzl.businessedition.R
import com.hpzl.businessedition.adapter.Main1FragmentAdapter
import com.hpzl.businessedition.base.BaseFragment
import com.hpzl.businessedition.customerview.TabTitle
import com.hpzl.businessedition.iview.Main1View
import com.hpzl.businessedition.model.ReserveTopModel
import com.hpzl.businessedition.presenter.Main1Present
import com.hpzl.businessedition.utils.SPUtils
import kotlinx.android.synthetic.main.viewpager1fragment.*

import me.yokeyword.fragmentation.SupportFragment


/**
*
* @author ViewPager1Fragment
* @date 16/6/5
*/
class Main1Fragment : BaseFragment(), View.OnClickListener, Main1View {

    override fun setReserveTopData(t: ReserveTopModel) {
        val value = arrayOf(t.content.waiteQueue, t.content.waiteOrder, t.content.noArrive, t.content.orderDone)
        titles.forEachIndexed { index, s ->
            if (tablayout != null) {
                val tab = tablayout.getTabAt(index)//获得每一个tab
                TabTitle(_mActivity)
                val tabTitle = TabTitle(_mActivity)
                tab?.customView = tabTitle
                if (index == 0) tabTitle.setchecked(true)
                tabTitle.setValue(s, value[index])
            }

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
        return inflater.inflate(R.layout.viewpager1fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = mutableListOf<BaseFragment>()

        list.add(Main1_1Fragment())
        list.add(Main1_2Fragment())
        list.add(Main1_3Fragment())
        list.add(Main1_4Fragment())



        viewpager.adapter = Main1FragmentAdapter(fragmentManager, list)
        tablayout.setupWithViewPager(viewpager)

        iv_qrScan.setOnClickListener(this)
        tv_search.setOnClickListener(this)
        val main1Present = Main1Present(this)
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


    companion object {
        fun newInstance(): Main1Fragment {
            val args = Bundle()
            val fragment = Main1Fragment()
            fragment.arguments = args
            return fragment
        }
    }
}
