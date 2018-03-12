package com.hpzl.businessedition.presenter

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.hpzl.businessedition.iview.Main1_1234View
import com.hpzl.businessedition.model.ReserveMainModel
import com.hpzl.businessedition.rx.APIServices
import com.hpzl.businessedition.utils.SPUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MultipartBody
import org.json.JSONObject
import java.nio.charset.Charset

/**
 * @author admin
 * @date 2018/1/31
 */

class Main1_1234Present(val context: Context, val main1_1234View: Main1_1234View) {
    fun getMain1_1234Data(page: String, statusid: String, action: String) {
        val list = mutableListOf<MultipartBody.Part>()
        list.add(MultipartBody.Part.createFormData("token", SPUtils.getString("token", "")))
        list.add(MultipartBody.Part.createFormData("page", page))
        list.add(MultipartBody.Part.createFormData("size", "10"))
        list.add(MultipartBody.Part.createFormData("statusid", statusid))
        APIServices.getApi()
                .reserve_indexs(list)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val json = String(it.bytes(), Charset.defaultCharset())
                    Log.i("json", json)
                    if (JSONObject(json).getInt("code") != 0) Toast.makeText(context, JSONObject(json).getString("message"), Toast.LENGTH_SHORT).show()
                    else {
                        val model = Gson().fromJson(json, ReserveMainModel::class.java)
                        main1_1234View.setMain1_1234Data(model,action)

                    }

                })
    }

}
