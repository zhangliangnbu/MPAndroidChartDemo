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

    private val json2= "{\n" +
            "    \"maxValuePoint\": {\n" +
            "      \"fundUnitValue\": 1.9000,\n" +
            "      \"publishDay\": 1532016000000,\n" +
            "      \"riseAndFall\": 0.9000\n" +
            "    },\n" +
            "    \"minValuePoint\": {\n" +
            "      \"fundUnitValue\": 0.5500,\n" +
            "      \"publishDay\": 1531411200000,\n" +
            "      \"riseAndFall\": -0.4500\n" +
            "    },\n" +
            "    \"count\": 13,\n" +
            "    \"contrastData\": [\n" +
            "      {\n" +
            "        \"fundUnitValue\": 3459.184,\n" +
            "        \"publishDay\": 1531065600000,\n" +
            "        \"riseAndFall\": 0.0000\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 3467.516,\n" +
            "        \"publishDay\": 1531152000000,\n" +
            "        \"riseAndFall\": 0.0024\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 3407.53,\n" +
            "        \"publishDay\": 1531238400000,\n" +
            "        \"riseAndFall\": -0.0149\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 3481.056,\n" +
            "        \"publishDay\": 1531324800000,\n" +
            "        \"riseAndFall\": 0.0063\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 3492.69,\n" +
            "        \"publishDay\": 1531411200000,\n" +
            "        \"riseAndFall\": 0.0097\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 3472.086,\n" +
            "        \"publishDay\": 1531670400000,\n" +
            "        \"riseAndFall\": 0.0037\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 3449.377,\n" +
            "        \"publishDay\": 1531756800000,\n" +
            "        \"riseAndFall\": -0.0028\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 3431.323,\n" +
            "        \"publishDay\": 1531843200000,\n" +
            "        \"riseAndFall\": -0.0081\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 3428.343,\n" +
            "        \"publishDay\": 1531929600000,\n" +
            "        \"riseAndFall\": -0.0089\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 3492.894,\n" +
            "        \"publishDay\": 1532016000000,\n" +
            "        \"riseAndFall\": 0.0097\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 3525.75,\n" +
            "        \"publishDay\": 1532275200000,\n" +
            "        \"riseAndFall\": 0.0192\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 3581.706,\n" +
            "        \"publishDay\": 1532361600000,\n" +
            "        \"riseAndFall\": 0.0354\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 3577.752,\n" +
            "        \"publishDay\": 1532448000000,\n" +
            "        \"riseAndFall\": 0.0343\n" +
            "      }\n" +
            "    ],\n" +
            "    \"latestData\": [\n" +
            "      {\n" +
            "        \"fundUnitValue\": 1.0000,\n" +
            "        \"publishDay\": 1531065600000,\n" +
            "        \"riseAndFall\": 0.0000\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 0.8000,\n" +
            "        \"publishDay\": 1531152000000,\n" +
            "        \"riseAndFall\": -0.2000\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 1.3000,\n" +
            "        \"publishDay\": 1531238400000,\n" +
            "        \"riseAndFall\": 0.3000\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 0.7800,\n" +
            "        \"publishDay\": 1531324800000,\n" +
            "        \"riseAndFall\": -0.2200\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 0.5500,\n" +
            "        \"publishDay\": 1531411200000,\n" +
            "        \"riseAndFall\": -0.4500\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 1.3000,\n" +
            "        \"publishDay\": 1531670400000,\n" +
            "        \"riseAndFall\": 0.3000\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 0.7800,\n" +
            "        \"publishDay\": 1531756800000,\n" +
            "        \"riseAndFall\": -0.2200\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 0.5500,\n" +
            "        \"publishDay\": 1531843200000,\n" +
            "        \"riseAndFall\": -0.4500\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 1.6000,\n" +
            "        \"publishDay\": 1531929600000,\n" +
            "        \"riseAndFall\": 0.6000\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 1.9000,\n" +
            "        \"publishDay\": 1532016000000,\n" +
            "        \"riseAndFall\": 0.9000\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 1.1000,\n" +
            "        \"publishDay\": 1532275200000,\n" +
            "        \"riseAndFall\": 0.1000\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 0.9800,\n" +
            "        \"publishDay\": 1532361600000,\n" +
            "        \"riseAndFall\": -0.0200\n" +
            "      },\n" +
            "      {\n" +
            "        \"fundUnitValue\": 0.9500,\n" +
            "        \"publishDay\": 1532448000000,\n" +
            "        \"riseAndFall\": -0.0500\n" +
            "      }\n" +
            "    ]\n" +
            "  }"

    fun mock():FundNetValueTrendModel {
        return Gson().fromJson(json, FundNetValueTrendModel::class.java)
    }
    fun mockNormal():FundNetValueTrendModel {
        return Gson().fromJson(json2, FundNetValueTrendModel::class.java)
    }
}