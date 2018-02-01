package com.hpzl.businessedition.views


import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.view.MenuItem
import com.hpzl.businessedition.R
import com.hpzl.businessedition.base.BaseActivity
import com.hpzl.businessedition.base.BaseFragment
import com.hpzl.businessedition.customerview.BottomBar
import com.hpzl.businessedition.customerview.BottomBarTab

import com.hpzl.businessedition.utils.BottomNavigationViewHelper
import com.hpzl.businessedition.views.main.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), BaseFragment.OnBackToFirstListener, BottomBar.OnTabSelectedListener {
    override fun onTabSelected(position: Int, prePosition: Int) {
        showHideFragment(mFragments[position], mFragments[prePosition])
    }

    override fun onTabUnselected(position: Int) {

    }

    override fun onTabReselected(position: Int) {
        val currentFragment = mFragments[position]
        val count = currentFragment.childFragmentManager.backStackEntryCount

        // 如果不在该类别Fragment的主页,则回到主页;
        if (count > 1) {
            when (currentFragment) {
                is Main1Fragment -> currentFragment.popToChild(ViewPager1Fragment::class.java, false)
                is Main2Fragment -> currentFragment.popToChild(ViewPager2Fragment::class.java, false)
                is Main3Fragment -> currentFragment.popToChild(ViewPager3Fragment::class.java, false)
                is Main4Fragment -> currentFragment.popToChild(ViewPager4Fragment::class.java, false)
                //else -> (currentFragment as? Main5Fragment)?.popToChild(MeFragment::class.java, false)
            }
            return
        }


        // 这里推荐使用EventBus来实现 -> 解耦
        /* if (count == 1) {
             // 在FirstPagerFragment中接收, 因为是嵌套的孙子Fragment 所以用EventBus比较方便
             // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
             EventBusActivityScope.getDefault(this@MainActivity).post(TabSelectedEvent(position))
         }*/
    }


    val mFragments = mutableListOf<BaseFragment>()
            .addElement(Main1Fragment())
            .addElement(Main2Fragment()).addElement(Main3Fragment()).addElement(Main4Fragment()).addElement(Main5Fragment())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val firstFragment = findFragment(Main1Fragment::class.java)

        if (firstFragment == null) {
            mFragments[0] = Main1Fragment.newInstance()
            mFragments[1] = Main2Fragment.newInstance()
            mFragments[2] = Main3Fragment.newInstance()
            mFragments[3] = Main4Fragment.newInstance()
            mFragments[4] = Main5Fragment.newInstance()

            loadMultipleRootFragment(R.id.display, 0,
                    mFragments[0],
                    mFragments[1],
                    mFragments[2],
                    mFragments[3],
                    mFragments[4])
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            mFragments[0] = firstFragment
            mFragments[1] = findFragment(Main2Fragment::class.java)
            mFragments[2] = findFragment(Main3Fragment::class.java)
            mFragments[3] = findFragment(Main4Fragment::class.java)
            mFragments[4] = findFragment(Main5Fragment::class.java)
        }

        showHideFragment(mFragments[0], mFragments[0])


        bottomBar
                .addItem(BottomBarTab(this, R.drawable.icon_safe, "预订"))
                .addItem(BottomBarTab(this, R.drawable.icon_safe, "房态"))
                .addItem(BottomBarTab(this, R.drawable.icon_safe, "套餐"))
                .addItem(BottomBarTab(this, R.drawable.icon_safe, "量贩"))
                .addItem(BottomBarTab(this, R.drawable.icon_safe, "我的"))

        // 模拟未读消息
        //bottomBar.getItem(0).setUnreadCount(9)
        bottomBar.setOnTabSelectedListener(this)


    }

    fun MutableList<BaseFragment>.addElement(fragment: BaseFragment): MutableList<BaseFragment> {
        add(fragment)
        return this
    }

    override fun onBackPressedSupport() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            pop()
        } else {
            ActivityCompat.finishAfterTransition(this)
        }
    }

    override fun onBackToFirstFragment() {
        bottomBar.setCurrentItem(0)
    }
}
