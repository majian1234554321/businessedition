package com.hpzl.businessedition.rx

import io.reactivex.Flowable
import io.reactivex.FlowableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Publisher

/**
 *
 * @author admin
 * @date 2018/1/30
 */
class FlowableTransformer2<T> : FlowableTransformer<T,T> {
    override fun apply(upstream: Flowable<T>): Flowable<T> {
        return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}