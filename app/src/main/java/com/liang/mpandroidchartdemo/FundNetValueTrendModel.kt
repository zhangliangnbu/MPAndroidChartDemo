package com.liang.mpandroidchartdemo

import java.io.Serializable

data class FundNetValueTrendModel(val contrastData: List<FundNetValueModel>,
                                  val count: Int,
                                  val latestData: List<FundNetValueModel>,
                                  val maxValuePoint: FundNetValueModel,
                                  val minValuePoint: FundNetValueModel) : Serializable