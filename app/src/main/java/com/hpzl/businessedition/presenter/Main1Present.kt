package com.hpzl.businessedition.presenter

import android.util.Log
import com.hpzl.businessedition.iview.Main1View
import com.hpzl.businessedition.model.ReserveTopModel
import com.hpzl.businessedition.rx.APIServices
import com.hpzl.businessedition.rx.Consumer2
import com.hpzl.businessedition.rx.FlowableTransformer2
import okhttp3.MultipartBody

/**
 *
 * @author admin
 * @date 2018/1/31
 */
class Main1Present(val main1View: Main1View) {
    fun getTopcount(token: String) {
        val args = MultipartBody.Part.createFormData("token", token)
        APIServices.getApi().reserve_top(args)
                .compose(FlowableTransformer2<ReserveTopModel>())
                .subscribe(object : Consumer2<ReserveTopModel>() {
                    override fun failed(t: String?) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        Log.i("TAG",t+"1")
                        main1View.setFailedData(t)
                    }

                    override fun successed(t: ReserveTopModel) {
                        main1View.setReserveTopData(t)
                    }

                })

    }
}