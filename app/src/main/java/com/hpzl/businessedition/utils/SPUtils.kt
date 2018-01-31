package com.hpzl.businessedition.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.hpzl.businessedition.base.BaseApp
import com.hpzl.businessedition.model.LoginModel

/**
 * @author cxw
 * @time 2016/3/18 0018 15:02
 * @des 保存一些公有的属性到sp
 * @updateAuthor tylz
 * @updateDate 2016/3/18 0018
 * @updateDes
 */
object SPUtils {

    private val mSp: SharedPreferences = BaseApp.instance.getSharedPreferences("fanc", Context.MODE_PRIVATE)
    private val mEditor: Editor

    init {
        mEditor = mSp.edit()
    }

    /**
     * 保存boolean型变量
     */
    fun putBoolean(key: String?, value: Boolean) {
        if (key != null) {
            mEditor.putBoolean(key, value)
            mEditor.commit()
        }
    }

    /**
     * 保存String型变量
     */
    fun putString(key: String?, value: String) {
        if (key != null) {
            mEditor.putString(key, value)
            mEditor.commit()
        }
    }

    /**
     * 保存int型变量
     */
    fun putInt(key: String?, value: Int) {
        if (key != null) {
            mEditor.putInt(key, value)
            mEditor.commit()
        }
    }

    /**
     * 保存float型变量
     */
    fun putFloat(key: String?, value: Float) {
        if (key != null) {
            mEditor.putFloat(key, value)
            mEditor.commit()
        }
    }

    /**
     * 得到int值
     */
    fun getInt(key: String, defValue: Int): Int {
        return mSp.getInt(key, defValue)
    }

    /**
     * 得到float值
     */
    fun getFloat(key: String, defValue: Int): Float {
        return mSp.getFloat(key, defValue.toFloat())
    }

    /**
     * 得到boolean值
     */
    fun getBoolean(key: String, defValue: Boolean): Boolean {
        return mSp.getBoolean(key, defValue)
    }

    /**
     * 得到String值
     */
    fun getString(key: String, defValue: String): String {
        return mSp.getString(key, defValue)
    }

    /**
     * 删除Key值,返回boolean是否执行成功！
     */
    fun removeKey(key: String): Boolean {
        return mSp.edit()
                .remove(key)
                .commit()
    }

    /**
     * 删除全部Key值,返回boolean是否执行成功！
     */
    fun clear(): Boolean {
        return mSp.edit()
                .clear()
                .commit()
    }

    fun save(t: LoginModel) {
        putString("userId", t.content.id)
        putString("store_id", t.content.store_id)
        putString("mobile", t.content.mobile)
        putString("token", t.content.token)
        putString("status", t.content.status)
    }

}
