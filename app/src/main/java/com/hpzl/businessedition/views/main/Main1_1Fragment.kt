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
import com.jcodecraeer.xrecyclerview.XRecyclerView
import kotlinx.android.synthetic.main.main1_1fragment.*


/**
 *
 * @author admin
 * @date 2018/1/30
 */
class Main1_1Fragment : BaseFragment(), XRecyclerView.LoadingListener, Main1_1234View {
    override fun setMain1_1234Data(t: ReserveMainModel) {

        xRecyclerView.adapter = Main1_1234Adapter(mContext, t.content)
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

    private val TYPE: String = "4"
    var page = 0
    lateinit var main1_1234Present: Main1_1234Present

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(inflater.context, R.layout.main1_1fragment, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        xRecyclerView.layoutManager = LinearLayoutManager(mContext)
        xRecyclerView.setLoadingListener(this)
        page = 0
        main1_1234Present = Main1_1234Present(mContext, this)
        main1_1234Present.getMain1_1234Data(page.toString(), TYPE, Constants.onRefresh)


    }
}