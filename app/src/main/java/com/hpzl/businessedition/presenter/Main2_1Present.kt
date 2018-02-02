package com.hpzl.businessedition.presenter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.google.gson.Gson
import com.hpzl.businessedition.adapter.Main2_1Adapter
import com.hpzl.businessedition.base.BaseActivity
import com.hpzl.businessedition.iview.Main2_1View
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
 * @date 2018/2/2
 */
class Main2_1Present( val main2_1View: Main2_1View) {
    fun loadData() {
        val args = MultipartBody.Part.createFormData("token", SPUtils.getString("token", ""))
        APIServices.getApi().roomtype(args)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer2<ResponseBody>() {
                    override fun failed(value: String) {
                        Log.i("Main2_1Fragment", value)
                        main2_1View.setFailedData(value)

                    }

                    override fun successed(value: String) {

                        Log.i("Main2_1Fragment", value)
                       main2_1View.setSucessedData(value)

                    }
                })
    }
}