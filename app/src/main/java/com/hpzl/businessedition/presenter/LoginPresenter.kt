package com.hpzl.businessedition.presenter

import android.content.Context
import android.util.Log
import com.hpzl.businessedition.iview.LoginView
import com.hpzl.businessedition.model.LoginModel
import com.hpzl.businessedition.rx.APIServices
import com.hpzl.businessedition.rx.Consumer2
import com.hpzl.businessedition.rx.FlowableTransformer2
import com.hpzl.businessedition.utils.AppUserInfo
import com.hpzl.businessedition.utils.SPUtils
import okhttp3.MultipartBody

/**
 *
 * @author admin
 * @date 2018/1/29
 */
class LoginPresenter(val context: Context, val loginView: LoginView) : BasePresent {
    fun login(mobile: String, password: String, deviceid: String, devicetype: String) {

        val list = mutableListOf<MultipartBody.Part>()


        list.add(MultipartBody.Part.createFormData("password", password))
        list.add(MultipartBody.Part.createFormData("deviceid", deviceid))
        list.add(MultipartBody.Part.createFormData("devicetype", devicetype))
         list.add(MultipartBody.Part.createFormData("mobile", mobile))


        val Disposable = APIServices.getApi()
                .login(list)
                .compose(FlowableTransformer2<LoginModel>())
                .subscribe(object : Consumer2<LoginModel>() {
                    override fun failed(t: String?) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun successed(t: LoginModel) {
                        Log.i("TAG", t.message)

                        SPUtils.save(t)

                    }
                })


    }
}