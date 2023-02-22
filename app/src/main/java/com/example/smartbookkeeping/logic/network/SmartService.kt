package com.example.smartbookkeeping.logic.network

import com.example.smartbookkeeping.logic.model.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface SmartService {
    @POST("bill/submit")
    fun submitBill(@Body submitBills: SubmitBill):Call<ResponseBody>

    @DELETE("bill/delete")
    fun deleteBill(@Path("id") id :Int):Call<ResponseBody>

    @POST("bill/get/bt/time")
    fun getBillByTime(@Body getBillDataByTime: GetBillDataByTime):Call<GetBillByTime>

    @POST("bill/get/bt/amount")
    fun getBillByMoney(@Body getBillDataByMoney: GetBillDataByMoney):Call<GetBillByTime>

    @GET("bill/get/sum")
    fun getSum(@Query("e") early:String,@Query("l") later:String, @Query("b") bill:Int):Call<Int>


}