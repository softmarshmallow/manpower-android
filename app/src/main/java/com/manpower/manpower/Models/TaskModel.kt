package com.manpower.manpower.Models

import java.util.*


class TaskModel {

    var ID :Int = 0
    lateinit var TaskName : String
    lateinit var Worker : WorkerModel
    lateinit var Boss : String // todo Boss Model
    lateinit var Location : String
    lateinit var Address : String
    lateinit var StartDate : Date
    lateinit var SndDate : Date
    var Pay : Int = 0
}