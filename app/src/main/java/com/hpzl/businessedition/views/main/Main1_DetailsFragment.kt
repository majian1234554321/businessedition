package com.hpzl.businessedition.views.main

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.hpzl.businessedition.R
import com.hpzl.businessedition.adapter.Main1_DetailsAdapter
import com.hpzl.businessedition.base.BaseFragment
import com.hpzl.businessedition.imp.TitleBarClickListener
import com.hpzl.businessedition.iview.Main1_DetailsView
import com.hpzl.businessedition.model.DetailsModel
import com.hpzl.businessedition.model.Main1DetalisModel
import com.hpzl.businessedition.presenter.Main1_DetailsPresent
import com.hpzl.businessedition.rx.APIServices
import com.hpzl.businessedition.rx.ObserableTrans2
import com.hpzl.businessedition.rx.Observer2
import com.hpzl.businessedition.utils.SPUtils
import com.jcodecraeer.xrecyclerview.XRecyclerView
import kotlinx.android.synthetic.main.main1_detailsfragment.*
import okhttp3.MultipartBody
import okhttp3.ResponseBody

/**
 *
 * @author admin
 * @date 2018/2/5
 */
class Main1_DetailsFragment : BaseFragment(), TitleBarClickListener, XRecyclerView.LoadingListener, Main1_DetailsView {
    override fun setSucessedData(value: String) {
        val jsonValue = Gson().fromJson(value, Main1DetalisModel::class.java)
        val model = mutableListOf<DetailsModel>()

        model.add(DetailsModel("订单号", jsonValue.content.orders.bookSn, Color.parseColor("#C4483C")))
        model.add(DetailsModel("订单状态", jsonValue.content.orders.bookSn, Color.parseColor("#C4483C")))
        model.add(DetailsModel("姓名", jsonValue.content.orders.bookSn, Color.parseColor("#C4483C")))

        model.add(DetailsModel("手机", jsonValue.content.orders.mobile, Color.parseColor("#C4483C")))
        model.add(DetailsModel("房型", jsonValue.content.orders.bookSn, Color.parseColor("#C4483C")))

        model.add(DetailsModel("预订类型", when (jsonValue.content.orders.type) {
        //type string 预定类型 1预付预定2信用预定3充值5结单 6 套餐预订 7 优惠预订
            "1" -> {
                "预付预定"
            }
            "2" -> {
                "信用预定"
            }
            "3" -> {
                "充值"
            }
            "4" -> {
                ""
            }
            "5" -> {
                "结单"
            }
            "6" -> {
                "套餐预订"
            }
            "7" -> {
                "优惠预订"
            }
            else -> {
                jsonValue.content.orders.type
            }
        }, Color.parseColor("#C4483C")))

        model.add(DetailsModel("到店时间", jsonValue.content.orders.bookSn, Color.parseColor("#C4483C")))
        model.add(DetailsModel("下单时间", jsonValue.content.orders.bookSn, Color.parseColor("#C4483C")))
        model.add(DetailsModel("车位", jsonValue.content.orders.carNum, Color.parseColor("#C4483C")))

        model.add(DetailsModel("人数", jsonValue.content.orders.peopleNum, Color.parseColor("#C4483C")))
        model.add(DetailsModel("订金", jsonValue.content.orders.bookSn, Color.parseColor("#C4483C")))
        model.add(DetailsModel("消费", jsonValue.content.orders.bookSn, Color.parseColor("#C4483C")))

        model.add(DetailsModel("不参与优惠金额", jsonValue.content.orders.bookSn, Color.parseColor("#C4483C")))
        model.add(DetailsModel("折扣", jsonValue.content.orders.bookSn, Color.parseColor("#C4483C")))
        model.add(DetailsModel("实际支付", jsonValue.content.orders.bookSn, Color.parseColor("#C4483C")))

        model.add(DetailsModel("支付方式", when (jsonValue.content.orders.status) {
        //status string 状态 0 待付款 1已取消 2 预定成功 3 正在消费 4 已结算 5 待处理 6 待排 7 未到 8 未付定金 9 已评论
            "0" -> {
                "待付款"
            }
            "1" -> {
                "已取消"
            }
            "2" -> {
                "预定成功"
            }
            "3" -> {
                "正在消费"
            }
            "4" -> {
                "已结算"
            }
            "5" -> {
                "待处理"
            }
            "6" -> {
                "待排"
            }
            "7" -> {
                "未到"
            }
            "8" -> {
                "未付定金"
            }
            "9" -> {
                "已评论"
            }
            else -> {
                jsonValue.content.orders.payMethod
            }
        }, Color.parseColor("#C4483C")))
        model.add(DetailsModel("备注", jsonValue.content.orders.remark, Color.parseColor("#C4483C")))
        model.add(DetailsModel("分配房间号", jsonValue.content.orders.bookSn, Color.parseColor("#C4483C")))
        if (xRecyclerView != null) {
            xRecyclerView.refreshComplete()
            xRecyclerView.layoutManager = LinearLayoutManager(mContext)
            xRecyclerView.adapter = Main1_DetailsAdapter(mContext, model)
        }

    }


    var id: String? = null

    override fun setFailedData(value: String) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoadMore() = Unit

    override fun onRefresh() {
        Main1_DetailsPresent(this).loadData(id)
    }

    override fun setOnLeftClickListener() {
        _mActivity.onBackPressed()
    }

    override fun setOnRightClickListener() = Unit

    companion object {
        fun newInstance(id: String?): Main1_DetailsFragment {
            val args = Bundle()
            val fragment = Main1_DetailsFragment()
            fragment.arguments = args
            args.putString("id", id)
            return fragment
        }

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(mContext, R.layout.main1_detailsfragment, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        id = arguments?.getString("id")
        tbv.setTitle("详情")
        tbv.setOnLeftClickListener(this)
        xRecyclerView.addItemDecoration(DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL))
        xRecyclerView.setLoadingMoreEnabled(false)
        xRecyclerView.setLoadingListener(this)

        Main1_DetailsPresent(this).loadData(id)

    }

}