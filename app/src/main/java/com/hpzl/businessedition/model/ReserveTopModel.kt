package com.hpzl.businessedition.model

import com.google.gson.annotations.SerializedName
import com.hpzl.businessedition.base.BaseModel


/**
 *
 * @author admin
 * @date 2018/1/31
 */

 class ReserveTopModel: BaseModel(){


 @SerializedName("content") var content: Contents = Contents()
}


data class Contents(
        @SerializedName("waite_order") var waiteOrder: String = "", //0
        @SerializedName("waite_queue") var waiteQueue: String = "", //0
        @SerializedName("no_arrive") var noArrive: String = "", //0
        @SerializedName("order_done") var orderDone: String = "" //5
)