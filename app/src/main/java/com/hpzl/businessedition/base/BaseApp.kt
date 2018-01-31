package com.hpzl.businessedition.base

import android.app.Application

/**
 *
 * @author admin
 * @date 2018/1/29
 */
class BaseApp : Application() {
    companion object {
        lateinit var instance: BaseApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}