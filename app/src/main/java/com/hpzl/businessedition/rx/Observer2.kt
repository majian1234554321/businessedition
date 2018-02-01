package com.hpzl.businessedition.rx

import android.widget.Toast
import com.google.gson.Gson
import com.hpzl.businessedition.model.ReserveMainModel
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import okhttp3.ResponseBody
import org.json.JSONObject
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.nio.charset.Charset


/**
 *
 * @author admin
 * @date 2018/1/31
 */
abstract class Observer2<T: okhttp3.ResponseBody> : Observer<T> {
    override fun onSubscribe(d: Disposable) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNext(t: T) {
        val json = String(t.bytes(), Charset.defaultCharset())
        if (JSONObject(json).getInt("code") != 0) {
            failed(JSONObject(json).getString("message"))
        } else {
            successed(json)

        }
    }

    override fun onError(e: Throwable) {
        failed(e.toString())
    }

    override fun onComplete() = Unit




    abstract fun failed(value: String)

    abstract fun successed(value: String)


}