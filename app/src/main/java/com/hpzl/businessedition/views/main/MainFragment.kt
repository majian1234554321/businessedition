package com.hpzl.businessedition.views.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hpzl.businessedition.R
import com.hpzl.businessedition.base.BaseFragment
import com.hpzl.businessedition.customerview.BottomBar
import com.hpzl.businessedition.customerview.BottomBarTab
import kotlinx.android.synthetic.main.mainfragment.*
import me.yokeyword.fragmentation.SupportFragment


/**
 *
 * @author admin
 * @date 2018/2/2
 */
class MainFragment : BaseFragment(), BottomBar.OnTabSelectedListener {

    override fun onTabSelected(position: Int, prePosition: Int) {
        showHideFragment(mFragments[position], mFragments[prePosition])



        val tab = bottomBar.getItem(0)
        if (position == 0) {
            tab.unreadCount = 0
        } else {
            tab.unreadCount = 0
        }
    }

    override fun onTabUnselected(position: Int) {

    }

    override fun onTabReselected(position: Int) {


        // 这里推荐使用EventBus来实现 -> 解耦
        /* if (count == 1) {
             // 在FirstPagerFragment中接收, 因为是嵌套的孙子Fragment 所以用EventBus比较方便
             // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
            EventBusActivityScope.getDefault(_mActivity).post(new TabSelectedEvent(position));
         }*/
    }


    val mFragments = mutableListOf<BaseFragment>()
            .addElement(Main1Fragment())
            .addElement(Main2Fragment()).addElement(Main3Fragment()).addElement(Main4Fragment()).addElement(Main5Fragment())

    companion object {
        fun newInstance(): MainFragment {

            val args = Bundle()

            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.mainfragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
                .addItem(BottomBarTab(mContext, R.drawable.icon_safe, "预订"))
                .addItem(BottomBarTab(mContext, R.drawable.icon_safe, "房态"))
                .addItem(BottomBarTab(mContext, R.drawable.icon_safe, "套餐"))
                .addItem(BottomBarTab(mContext, R.drawable.icon_safe, "量贩"))
                .addItem(BottomBarTab(mContext, R.drawable.icon_safe, "我的"))

        // 模拟未读消息
        //bottomBar.getItem(0).setUnreadCount(9)
        bottomBar.setOnTabSelectedListener(this)


    }

    fun MutableList<BaseFragment>.addElement(fragment: BaseFragment): MutableList<BaseFragment> {
        add(fragment)
        return this
    }

    override fun onFragmentResult(requestCode: Int, resultCode: Int, data: Bundle) {
        super.onFragmentResult(requestCode, resultCode, data)
        /*if (requestCode == REQ_MSG && resultCode == ISupportFragment.RESULT_OK) {

        }*/
    }

    /**
     * start other BrotherFragment
     */
    fun startBrotherFragment(targetFragment: SupportFragment) {
        start(targetFragment)
    }
}