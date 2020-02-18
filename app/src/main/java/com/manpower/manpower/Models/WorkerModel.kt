package com.manpower.manpower.Models


class WorkerModel {
    var ID : Int = 0
    lateinit var WorkerName:String
    lateinit var PhoneNumber : String
    var  Age : Int = 0
    lateinit var  Gender : String
    lateinit var WorkHistory : List<TaskModel>
    lateinit var Career :String
}
