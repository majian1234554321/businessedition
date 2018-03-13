package com.hpzl.businessedition.model

import com.google.gson.annotations.SerializedName


/**
 *
 * @author admin
 * @date 2018/2/5
 */


data class Main1DetalisModel(
        @SerializedName("code") var code: Int = 0, //0
        @SerializedName("message") var message: String = "", //请求成功
        @SerializedName("content") var content: ContentValue = ContentValue()
)

data class ContentValue(
        @SerializedName("orders") var orders: Orders = Orders(),
        @SerializedName("roomnumber") var roomnumber: List<Roomnumber> = listOf()
)

data class Roomnumber(
        @SerializedName("number") var number: String = "", //K01
        @SerializedName("id") var id: String = "" //1
)

data class Orders(
        @SerializedName("id") var id: String = "", //7
        @SerializedName("arrival_time") var arrivalTime: String = "", //1517311800
        @SerializedName("name") var name: String = "", //大包
        @SerializedName("number") var number: String = "", //1号公馆
        @SerializedName("nickname") var nickname: String = "", //123456test
        @SerializedName("mobile") var mobile: String = "", //18650762672
        @SerializedName("prepay") var prepay: String = "", //0.00
        @SerializedName("type") var type: String = "", //5
        @SerializedName("car_num") var carNum: String = "", //0
        @SerializedName("people_num") var peopleNum: String = "", //0
        @SerializedName("remark") var remark: String = "",
        @SerializedName("status") var status: String = "", //4
        @SerializedName("response") var response: Any = Any(), //null
        @SerializedName("roomnumber_id") var roomnumberId: String = "", //3
        @SerializedName("order_name") var orderName: String = "", //123456test
        @SerializedName("created_time") var createdTime: String ? = null, //1517278283
        @SerializedName("display_prepay") var displayPrepay: String = "", //0.00
        @SerializedName("display_balance") var displayBalance: String = "", //1000.00
        @SerializedName("coupon_amount") var couponAmount: String = "", //0.00
        @SerializedName("fee") var fee: String = "", //0.00
        @SerializedName("pay_method") var payMethod: String = "", //3
        @SerializedName("display_total") var displayTotal: String = "", //840.00
        @SerializedName("book_sn") var bookSn: String = "", //180130101123805887
        @SerializedName("discount_rate") var discountRate: String = "", //8.40
        @SerializedName("refund_fail_reason") var refundFailReason: String = "",
        @SerializedName("cancle_reason") var cancleReason: String? = null,
        @SerializedName("cancle_time") var cancleTime: String = "", //0
        @SerializedName("refund_time") var refundTime: String = "", //0
        @SerializedName("origin_prepay") var origin_prepay: String = "", //0
        @SerializedName("statustext") var statustext: String = "" //已结算
)
