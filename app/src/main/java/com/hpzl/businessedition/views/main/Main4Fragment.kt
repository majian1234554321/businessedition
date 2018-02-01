package com.hpzl.businessedition.views.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hpzl.businessedition.R
import com.hpzl.businessedition.adapter.Main4FragmentAdapter
import com.hpzl.businessedition.base.BaseFragment
import kotlinx.android.synthetic.main.main4fragment.*

/**
 *
 * @author admin
 * @date 2018/1/30
 */
class Main4Fragment : BaseFragment() {
    companion object {
        fun newInstance(): Main4Fragment {

            val args = Bundle()

            val fragment = Main4Fragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(mContext, R.layout.main4fragment, null)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (findChildFragment(ViewPager4Fragment::class.java) == null) {
            loadRootFragment(R.id.fl_4_container, ViewPager4Fragment.newInstance())
        }
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        // 这里可以不用懒加载,因为Adapter的场景下,Adapter内的子Fragment只有在父Fragment是show状态时,才会被Attach,Create
    }
}