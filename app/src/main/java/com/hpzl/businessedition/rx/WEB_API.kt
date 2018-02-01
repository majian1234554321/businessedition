package com.hpzl.businessedition.rx

import com.hpzl.businessedition.base.BaseModel
import com.hpzl.businessedition.model.LoginModel
import com.hpzl.businessedition.model.FindPasswordModel
import com.hpzl.businessedition.model.ReserveMainModel
import com.hpzl.businessedition.model.ReserveTopModel
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.internal.operators.observable.ObservableError
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

/**
 *
 * @author admin
 * @date 2018/1/29
 */
interface WEB_API {


    @Multipart
    @POST("Login/login")
    fun login(@Part args: List<MultipartBody.Part>): Flowable<LoginModel>


    @Multipart
    @POST("Login/verify")
    fun verify(@Part args: MultipartBody.Part): Flowable<BaseModel>

    @Multipart
    @POST("Login/findPassword")
    fun findPassword(@Part args: List<MultipartBody.Part>): Flowable<FindPasswordModel>

    @Multipart
    @POST("Reserve/reserve_indexs")
    fun reserve_indexs(@Part args: List<MultipartBody.Part>): Flowable<ResponseBody>

    @Multipart
    @POST("Reserve/reserve_top")
    fun reserve_top(@Part args: MultipartBody.Part): Flowable<ReserveTopModel>


    @Multipart
    @POST("My/roomtype")
    fun roomtype(@Part args: MultipartBody.Part): Observable<ResponseBody>

}