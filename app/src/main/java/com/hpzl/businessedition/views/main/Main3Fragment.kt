package com.hpzl.businessedition.views.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hpzl.businessedition.R
import com.hpzl.businessedition.adapter.Main3FragmentAdapter
import com.hpzl.businessedition.base.BaseFragment
import kotlinx.android.synthetic.main.main3fragment.*

/**
 *
 * @author admin
 * @date 2018/1/30
 */
class Main3Fragment : BaseFragment() {
    companion object {
        fun newInstance(): Main3Fragment {

            val args = Bundle()

            val fragment = Main3Fragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(mContext, R.layout.main3fragment, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (findChildFragment(ViewPager3Fragment::class.java) == null) {
            loadRootFragment(R.id.fl_3_container, ViewPager3Fragment.newInstance())
        }
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        // 这里可以不用懒加载,因为Adapter的场景下,Adapter内的子Fragment只有在父Fragment是show状态时,才会被Attach,Create
    }
}