package com.hpzl.businessedition.views.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hpzl.businessedition.R
import com.hpzl.businessedition.adapter.Main1_1234Adapter
import com.hpzl.businessedition.base.BaseFragment
import com.hpzl.businessedition.constant.Constants
import com.hpzl.businessedition.iview.Main1_1234View
import com.hpzl.businessedition.model.ReserveMainModel
import com.hpzl.businessedition.presenter.Main1_1234Present
import com.jcodecraeer.xrecyclerview.ProgressStyle
import com.jcodecraeer.xrecyclerview.XRecyclerView
import kotlinx.android.synthetic.main.main1_1fragment.*

/**
 *
 * @author admin
 * @date 2018/1/30
 */
class Main1_3Fragment : BaseFragment(), Main1_1234View, XRecyclerView.LoadingListener {
    lateinit var main1_1234Adapter: Main1_1234Adapter
    override fun setMain1_1234Data(t: ReserveMainModel, action: String) {
        if (Constants.onRefresh == action) {
            if (page == 0 && t.content.isEmpty()) {
                if (xRecyclerView != null)
                    xRecyclerView.visibility = View.GONE
                rrrrrr.visibility = View.VISIBLE
            } else {
                if (xRecyclerView != null)
                    xRecyclerView.visibility = View.VISIBLE
                rrrrrr.visibility = View.GONE
                main1_1234Adapter = Main1_1234Adapter(mContext, t.content, this)
                xRecyclerView.adapter = main1_1234Adapter
                xRecyclerView.refreshComplete()
            }


        } else {
            if (t.content.isNotEmpty()) {
                main1_1234Adapter.addData(t.content)
                xRecyclerView.loadMoreComplete()
            } else {
                xRecyclerView.setNoMore(true)
            }
        }

    }


    override fun onLoadMore() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        page++
        main1_1234Present.getMain1_1234Data(page.toString(), TYPE, Constants.onLoadMore)
    }

    override fun onRefresh() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        page = 0
        main1_1234Present.getMain1_1234Data(page.toString(), TYPE, Constants.onRefresh)
    }

    private val TYPE: String = "2"
    var page = 0
    lateinit var main1_1234Present: Main1_1234Present

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(inflater.context, R.layout.main1_1fragment, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader)
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate)
        xRecyclerView.defaultFootView.setLoadingHint("正在加载......")
        xRecyclerView.defaultFootView.setNoMoreHint("数据加载完毕")

        xRecyclerView.layoutManager = LinearLayoutManager(mContext)
        xRecyclerView.setLoadingListener(this)
        page = 0
        main1_1234Present = Main1_1234Present(mContext, this)
        main1_1234Present.getMain1_1234Data(page.toString(), TYPE, Constants.onRefresh)


    }
}