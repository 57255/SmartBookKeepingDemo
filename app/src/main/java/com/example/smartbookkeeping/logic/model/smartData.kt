package com.example.smartbookkeeping.logic.model

data class SubmitBill(
    val amount: Int,
    val bill: Int,
    val category: String,
    val consumeTime: String,
    val remark: String
)
data class GetBillByTime(
    val code: Int,
    val `data`: List<BillData>,
    val message: String
)
data class BillData(
    val amount: Double,
    val bill: Boolean,
    val category: String,
    val consumeTime: String,
    val createTime: String,
    val id: Long,
    val remark: String
)
data class GetBillDataByTime(
    val early:String,
    val later:String,
    val bill:Int,
    val pageNum:String,
    val pageSize:String
)
data class GetBillDataByMoney(
    val low:Number,
    val high:Number,
    val bill:Int,
    val pageNum:String,
    val pageSize:String
)