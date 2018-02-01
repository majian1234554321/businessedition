package com.hpzl.businessedition.views.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.hpzl.businessedition.R
import com.hpzl.businessedition.adapter.Main2_1Adapter
import com.hpzl.businessedition.base.BaseActivity
import com.hpzl.businessedition.base.BaseFragment
import com.hpzl.businessedition.model.RoomTypeModel
import com.hpzl.businessedition.rx.APIServices
import com.hpzl.businessedition.rx.Observer2
import com.hpzl.businessedition.utils.SPUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.main1_1fragment.*
import okhttp3.MultipartBody
import okhttp3.ResponseBody

/**
 *
 * @author admin
 * @date 2018/1/30
 */
class Main2_1Fragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(inflater.context, R.layout.main1_1fragment, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = MultipartBody.Part.createFormData("token", SPUtils.getString("token", ""))
        APIServices.getApi().roomtype(args)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer2<ResponseBody>() {
                    override fun failed(value: String) {
                        Log.i("Main2_1Fragment", value)
                        (mContext as BaseActivity).alertReSignIn()
                    }

                    override fun successed(value: String) {

                        Log.i("Main2_1Fragment", value)
                        val json = Gson().fromJson(value, RoomTypeModel::class.java)
                        if (xRecyclerView != null) {
                            xRecyclerView.layoutManager = LinearLayoutManager(mContext)
                            xRecyclerView.adapter = Main2_1Adapter(mContext, json.content)
                        }

                    }
                })
    }
}