package com.hpzl.businessedition.rx

import com.hpzl.businessedition.base.BaseModel
import io.reactivex.functions.Consumer

/**
 *
 * @author admin
 * @date 2018/1/30
 */
abstract class Consumer2<T : BaseModel> : Consumer<T> {
    override fun accept(t: T) {
        if ("0" == t.code) {
            successed(t)
        } else {
            failed(t.message)
        }
    }

    abstract fun failed(t: String?)

    abstract fun successed(t: T)



}