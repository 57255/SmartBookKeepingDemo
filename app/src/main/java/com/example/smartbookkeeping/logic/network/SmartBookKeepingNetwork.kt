package com.example.smartbookkeeping.logic.network

import com.example.smartbookkeeping.logic.model.GetBillDataByMoney
import com.example.smartbookkeeping.logic.model.GetBillDataByTime
import com.example.smartbookkeeping.logic.model.SubmitBill
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object SmartBookKeepingNetwork {
    private val smartService = ServiceCreator.create<SmartService>()
    suspend fun submitBill(submitBills: SubmitBill) = smartService.submitBill(submitBills).await()
    suspend fun deleteBill(id :Int)= smartService.deleteBill(id).await()
    suspend fun getBillByTime(getBillDataByTime: GetBillDataByTime)= smartService.getBillByTime(getBillDataByTime).await()
    suspend fun getBillByMoney(getBillDataByMoney: GetBillDataByMoney)= smartService.getBillByMoney(getBillDataByMoney).await()
    suspend fun getSum(early:String, later:String, bill:Int)= smartService.getSum(early,later, bill).await()
    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null"))
                }
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}