package com.hpzl.businessedition.iview

import com.hpzl.businessedition.model.ReserveTopModel

/**
 *
 * @author admin
 * @date 2018/1/31
 */
interface Main1View {
    fun setReserveTopData(t: ReserveTopModel)

    fun setFailedData(t: String?)
}