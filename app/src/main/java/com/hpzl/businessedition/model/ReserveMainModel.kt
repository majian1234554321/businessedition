package com.hpzl.businessedition.model

import com.hpzl.businessedition.base.BaseModel

/**
 * @author admin
 * @date 2018/1/31
 */

class ReserveMainModel : BaseModel() {

    /**
     * code : 0
     * message : 请求成功
     * content : [{"id":"7","arrival_time":"1517311800","name":"大包","number":"1号公馆","nickname":"123456test","pic":"http://testapi.51tzl.cn/Upload/user/avatar/images/20180126/20180126171138_90850.png","bigpic":"http://testapi.51tzl.cn/Upload/image/20171207/20171207102724_19352.png","mobile":"18650762672","people_num":"1","status":"4","order_name":"123456test","car_num":"0","created_time":"1517278283","display_prepay":"0.00","display_balance":"1000.00","coupon_amount":"0.00","fee":"0.00","pay_method":"3","display_total":"840.00"},{"id":"6","arrival_time":"1517311800","name":"大包","number":"1号公馆","nickname":"123456test","pic":"http://testapi.51tzl.cn/Upload/user/avatar/images/20180126/20180126171138_90850.png","bigpic":"http://testapi.51tzl.cn/Upload/image/20171207/20171207102724_19352.png","mobile":"18650762672","people_num":"1","status":"3","order_name":"123456test","car_num":"0","created_time":"1517278262","display_prepay":"0.00","display_balance":"0.00","coupon_amount":"0.00","fee":"0.00","pay_method":"0","display_total":"0.00"},{"id":"3","arrival_time":"1517221800","name":"小包","number":"K05","nickname":"王","pic":"http://testapi.51tzl.cn/Public/head_icon.png","bigpic":"http://testapi.51tzl.cn/Upload/image/20171206/20171206110852_46123.png","mobile":"13917045004","people_num":"1","status":"4","order_name":"王","car_num":"1","created_time":"1517210107","display_prepay":"0.00","display_balance":"20000.00","coupon_amount":"0.00","fee":"2000.00","pay_method":"3","display_total":"19200.00"},{"id":"2","arrival_time":"1517221800","name":"小包","number":"K05","nickname":"王","pic":"http://testapi.51tzl.cn/Public/head_icon.png","bigpic":"http://testapi.51tzl.cn/Upload/image/20171206/20171206110852_46123.png","mobile":"13917045004","people_num":"1","status":"4","order_name":"王","car_num":"1","created_time":"1517209705","display_prepay":"0.00","display_balance":"10000.00","coupon_amount":"0.00","fee":"100.00","pay_method":"3","display_total":"8520.00"},{"id":"1","arrival_time":"1517221800","name":"小包","number":"K05","nickname":"王","pic":"http://testapi.51tzl.cn/Public/head_icon.png","bigpic":"http://testapi.51tzl.cn/Upload/image/20171206/20171206110852_46123.png","mobile":"13917045004","people_num":"1","status":"3","order_name":"王","car_num":"1","created_time":"1517209643","display_prepay":"0.00","display_balance":"0.00","coupon_amount":"0.00","fee":"0.00","pay_method":"0","display_total":"0.00"}]
     */


    lateinit var content: Array<ContentBean>

    class ContentBean {
        /**
         * id : 7
         * arrival_time : 1517311800
         * name : 大包
         * number : 1号公馆
         * nickname : 123456test
         * pic : http://testapi.51tzl.cn/Upload/user/avatar/images/20180126/20180126171138_90850.png
         * bigpic : http://testapi.51tzl.cn/Upload/image/20171207/20171207102724_19352.png
         * mobile : 18650762672
         * people_num : 1
         * status : 4
         * order_name : 123456test
         * car_num : 0
         * created_time : 1517278283
         * display_prepay : 0.00
         * display_balance : 1000.00
         * coupon_amount : 0.00
         * fee : 0.00
         * pay_method : 3
         * display_total : 840.00
         */

        var id: String? = null
        var arrival_time: Long? = null
        var name: String? = null
        var number: String? = null
        var nickname: String? = null
        var pic: String? = null
        var bigpic: String? = null
        var mobile: String? = null
        var people_num: String? = null
        var status: String? = null
        var order_name: String? = null
        var car_num: String? = null
        var created_time: Long? = null
        var display_prepay: String? = null
        var display_balance: String? = null
        var coupon_amount: String? = null
        var fee: String? = null
        var pay_method: String? = null
        var display_total: String? = null
    }
}
