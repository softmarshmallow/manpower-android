package com.manpower.manpower.Models.MockDataSource

import com.manpower.manpower.Models.BossModel
import com.manpower.manpower.Models.TaskModel
import com.manpower.manpower.Models.WorkerModel


object MockDataSource {


    //region WorkerData

    val Worker_1 = WorkerModel().apply{

        ID = 1
        WorkerName = "김씨"
        PhoneNumber = "+82 010 0101 0101"
        Age = 82
        Gender = "Male"
        Career = "목수 10년 경력"
        WorkHistory = listOf(Task_1)

    }

    var Worker_2 = WorkerModel().apply{

        ID = 2
        WorkerName = "방씨"
        PhoneNumber = "+82 010 0101 0101"
        Age = 32
        Gender = "Male"
        Career = "목수 10년 경력"

    }


    var Worker_3 = WorkerModel().apply{

        ID = 3
        WorkerName = "장씨"
        PhoneNumber = "+82 010 0101 0101"
        Age = 24
        Gender = "Male"
        Career = "목수 10년 경력"

    }



    val AllWorkers : List<WorkerModel> = listOf(
            Worker_1,
            Worker_2,
            Worker_3
    )

    // endregion

    //region TaskData

    val Task_1 = TaskModel().apply {
        ID = 1
        TaskName = "토즈 인태리어 시공"
    }


    val Task_2 = TaskModel().apply {
        ID = 2
        TaskName = "토즈 인태리어 시공 2차"
    }


    val Task_3 = TaskModel().apply {
        ID = 3
        TaskName = "토즈 인태리어 시공 3차"
    }

    //endregion



}