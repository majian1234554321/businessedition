package com.hpzl.businessedition.views.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.hpzl.businessedition.R
import com.hpzl.businessedition.adapter.Main2_1Adapter
import com.hpzl.businessedition.base.BaseActivity
import com.hpzl.businessedition.base.BaseFragment
import com.hpzl.businessedition.iview.Main2_1View
import com.hpzl.businessedition.model.RoomTypeModel
import com.hpzl.businessedition.presenter.Main2_1Present
import com.hpzl.businessedition.utils.SPUtils
import com.hpzl.businessedition.views.login.LoginActivity
import com.jcodecraeer.xrecyclerview.XRecyclerView
import kotlinx.android.synthetic.main.main1_1fragment.*


/**
 *
 * @author admin
 * @date 2018/1/30
 */
class Main2_1Fragment : BaseFragment(), XRecyclerView.LoadingListener, Main2_1View {
    override fun setSucessedData(value: String) {
        val json = Gson().fromJson(value, RoomTypeModel::class.java)
        if (xRecyclerView != null && json != null && json.content != null && json.content.size > 0) {
            xRecyclerView.refreshComplete()
            xRecyclerView.layoutManager = LinearLayoutManager(mContext)
            xRecyclerView.adapter = Main2_1Adapter(mContext, json.content, this@Main2_1Fragment)
        } else {

        }
    }

    override fun setFailedData(value: String) {
        mContext.startActivity(Intent(mContext, LoginActivity::class.java))
        SPUtils.removeKey("token")
    }

    override fun onLoadMore() = Unit

    override fun onRefresh() {
        Main2_1Present(this).loadData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(inflater.context, R.layout.main1_1fragment, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        xRecyclerView.setLoadingMoreEnabled(false)
        xRecyclerView.setLoadingListener(this)
        xRecyclerView.post({
            xRecyclerView.refresh()
        })


    }


}