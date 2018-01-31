package com.hpzl.businessedition.presenter

import android.widget.Toast
import com.hpzl.businessedition.base.BaseApp
import com.hpzl.businessedition.base.BaseModel
import com.hpzl.businessedition.model.FindPasswordModel
import com.hpzl.businessedition.rx.APIServices
import com.hpzl.businessedition.rx.Consumer2
import com.hpzl.businessedition.rx.FlowableTransformer2
import okhttp3.MultipartBody

/**
 *
 * @author admin
 * @date 2018/1/31
 */
class UpdatePwdPresent {

    fun verifyCode(mobile: String) {
        val args = MultipartBody.Part.createFormData("mobile", mobile)
        val disposable = APIServices
                .getApi()
                .verify(args)
                .compose(FlowableTransformer2<BaseModel>())
                .subscribe(object : Consumer2<BaseModel>() {
                    override fun failed(t: String?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun successed(t: BaseModel) {
                        Toast.makeText(BaseApp.instance, "验证码发送成功", Toast.LENGTH_SHORT).show()
                    }

                })
    }

    fun findPassword(mobile: String, password: String, password1: String, code: String) {
        val list = mutableListOf<MultipartBody.Part>()
        list.add(MultipartBody.Part.createFormData("mobile", mobile))
        list.add(MultipartBody.Part.createFormData("password", password))
        list.add(MultipartBody.Part.createFormData("password1", password1))
        list.add(MultipartBody.Part.createFormData("code", code))


        APIServices.getApi()
                .findPassword(list)
                .compose(FlowableTransformer2<FindPasswordModel>())
                .subscribe(object : Consumer2<FindPasswordModel>() {
                    override fun failed(t: String?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun successed(t: FindPasswordModel) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })

    }
}