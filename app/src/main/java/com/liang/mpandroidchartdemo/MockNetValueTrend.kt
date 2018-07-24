package com.liang.mpandroidchartdemo

import com.google.gson.Gson

/**
 * created by zhangliang on 2018/7/23
 * profile: https://github.com/zhangliangnbu or zhangliangnbu@163.com
 */
class MockNetValueTrend {
    private val json = "{\n" +
            "    \"maxValuePoint\": {\n" +
            "      \"fundUnitValue\": 3409.28,\n" +
            "      \"publishDay\": 1531756800000,\n" +
            "      \"riseAndFall\": 0.6311\n" +
            "    },\n" +
            "    \"minValuePoint\": {\n" +
            "      \"fundUnitValue\": 3449.377,\n" +
            "      \"publishDay\": 1531756800000,\n" +
            "      \"riseAndFall\": -0.58\n" +
            "    },\n" +
            "    \"count\": 5,\n" +
            "    \"latestData\": [\n" +
            "      {\n" +
            "        \"fundUnitValue\": 0.95,\n" +
            "        \"publishDay\": 1527955200000,\n" +
            "        \"riseAndFall\": 0\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 0.98,\n" +
            "        \"publishDay\": 1528128000000,\n" +
            "        \"riseAndFall\": 0.0316\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 1.1,\n" +
            "        \"publishDay\": 1530547200000,\n" +
            "        \"riseAndFall\": 0.2579\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 1,\n" +
            "        \"publishDay\": 1531670400000,\n" +
            "        \"riseAndFall\": -0.0526\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 1.9,\n" +
            "        \"publishDay\": 1531756800000,\n" +
            "        \"riseAndFall\": -0.58\n" +
            "      }\n" +
            "    ],\n" +
            "    \"contrastData\": [\n" +
            "      {\n" +
            "        \"fundUnitValue\": 1.45,\n" +
            "        \"publishDay\": 1527955200000,\n" +
            "        \"riseAndFall\": 0\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 0.78,\n" +
            "        \"publishDay\": 1528128000000,\n" +
            "        \"riseAndFall\": 0.0533\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 1.3,\n" +
            "        \"publishDay\": 1530547200000,\n" +
            "        \"riseAndFall\": -0.2599\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 0.99,\n" +
            "        \"publishDay\": 1531670400000,\n" +
            "        \"riseAndFall\": 0.0126\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 1.55,\n" +
            "        \"publishDay\": 1531756800000,\n" +
            "        \"riseAndFall\": 0.6311\n" +
            "      }\n" +
            "    ]\n" +
            "  }"

    fun mock():FundNetValueTrendModel {
        return Gson().fromJson(json, FundNetValueTrendModel::class.java)
    }
}