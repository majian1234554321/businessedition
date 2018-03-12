package com.hpzl.businessedition.presenter

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.google.gson.Gson
import com.hpzl.businessedition.adapter.Main1_DetailsAdapter
import com.hpzl.businessedition.iview.Main1_DetailsView
import com.hpzl.businessedition.model.DetailsModel
import com.hpzl.businessedition.model.Main1DetalisModel
import com.hpzl.businessedition.rx.APIServices
import com.hpzl.businessedition.rx.ObserableTrans2
import com.hpzl.businessedition.rx.Observer2
import com.hpzl.businessedition.utils.SPUtils
import kotlinx.android.synthetic.main.main1_detailsfragment.*
import okhttp3.MultipartBody
import okhttp3.ResponseBody

/**
 *
 * @author admin
 * @date 2018/2/5
 */
class Main1_DetailsPresent(val main1_DetailsView: Main1_DetailsView) : BasePresent {
    fun loadData(id: String?) {
        val list = mutableListOf<MultipartBody.Part>()
        list.add(MultipartBody.Part.createFormData("token", SPUtils.getString("token", "")))
        list.add(MultipartBody.Part.createFormData("id", id))
        APIServices.getApi().order_detail(list)
                .compose(ObserableTrans2<ResponseBody>())
                .subscribe(object : Observer2<ResponseBody>() {
                    override fun failed(value: String) {
                        Log.i("Main1_DetailsFragment", value)
                        main1_DetailsView.setFailedData(value)
                    }

                    override fun successed(value: String) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        Log.i("Main1_DetailsFragment", value)
                        main1_DetailsView.setSucessedData(value)
                    }

                })
    }}