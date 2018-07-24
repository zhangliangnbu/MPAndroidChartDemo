package com.liang.mpandroidchartdemo

import java.io.Serializable

data class FundNetValueModel(val fundUnitValue:String,
                             val publishDay:Long,
                             val riseAndFall:String?) : Serializable