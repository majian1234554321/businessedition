package com.hpzl.businessedition.model

import com.google.gson.annotations.SerializedName
import com.hpzl.businessedition.base.BaseModel


/**
 *
 * @author admin
 * @date 2018/1/31
 */


data class FindPasswordModel(
        @SerializedName("code") override var code: String? = "", //0
        @SerializedName("message") override var message: String? = "", //请求成功
        @SerializedName("content") var content: Content = Content()
) : BaseModel()

data class Content(
        @SerializedName("id") var id: String = "", //43
        @SerializedName("store_id") var storeId: String = "", //1
        @SerializedName("mobile") var mobile: String = "", //13668018462
        @SerializedName("created_time") var createdTime: String = "", //1517209420
        @SerializedName("status") var status: String = "", //2
        @SerializedName("token") var token: String = "" //eyJpZCI6IjQzIiwibm9uY2UiOiJHY3RVVHZyTyIsIm1vYmlsZSI6IjEzNjY4MDE4NDYyIn0=
)
