package com.liang.mpandroidchartdemo

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chart_fund_trend.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onNothingSelected() {
            }

            @SuppressLint("SetTextI18n")
            override fun onValueSelected(e: Entry?, h: Highlight?) {
                if(e == null || h == null) {
                    return
                }
                val dataSet = chart_fund_trend.data.dataSets
                val setIndex = h.dataSetIndex
                val entryIndex = dataSet[setIndex].getEntryIndex(e)
                if(entryIndex == -1) {
                    return
                }
                val sb = StringBuilder()
                dataSet.forEachIndexed { i,set->
                    if(set is LineDataSet) {
                        val entry = set.values[entryIndex]
                        val time = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(Date(entry.x.toLong()))
                        sb.append("$time : ${entry.y} \n")
                    }
                }
                tv_desc.text = sb.toString()
            }

        })

        // grid
        chart_fund_trend.setDrawGridBackground(false)

        // x axis
        val xAxis = chart_fund_trend.xAxis
        xAxis.enableGridDashedLine(10f, 10f, 0f)
        xAxis.labelCount = 4
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.valueFormatter = MyCustomXAxisValueFormatter(chart_fund_trend.viewPortHandler)
        xAxis.setAvoidFirstLastClipping(true)

        // y axis
        val leftAxis = chart_fund_trend.axisLeft
        leftAxis.removeAllLimitLines()
        leftAxis.enableGridDashedLine(10f, 10f, 0f)
        leftAxis.labelCount = 4
        leftAxis.setDrawAxisLine(false)
        leftAxis.valueFormatter = MyCustomYAxisValueFormatter(chart_fund_trend.viewPortHandler)

        chart_fund_trend.axisRight.isEnabled = false

        // other
        with(chart_fund_trend) {
            description.isEnabled = false
            setScaleEnabled(false)
            setTouchEnabled(true)

            legend.isEnabled = false
        }

        updateChart(MockNetValueTrend().mock())
    }

    private fun updateChart(data: FundNetValueTrendModel) {

        // 数据
        val selfValues = data.latestData.mapIndexed { _, item ->
            return@mapIndexed Entry(item.publishDay.toFloat(), item.riseAndFall?.toFloat() ?: 0f)
        }
        val contrastValues = data.contrastData.mapIndexed { _, item ->
            return@mapIndexed Entry(item.publishDay.toFloat(), item.riseAndFall?.toFloat() ?: 0f)
        }
        val selfSet = LineDataSet(selfValues, "self data")
        val contrastSet = LineDataSet(contrastValues, "contrast data")

        // 样式
        fun initLineDataSet(sets: Array<LineDataSet>) {
            sets.forEach { set->
                with(set) {
                    lineWidth = 1f // 折线线宽

                    setDrawValues(false) // 点上是否显示值
                    setDrawIcons(false) // 点上是否显示图标
                    setDrawCircles(false) // 点上是否显示小圆圈
                    setDrawFilled(false) // 折线下面是否填充

                    isHighlightEnabled = true // 点击图表后绘制的十字线
                    highLightColor = Color.BLACK // 十字线颜色
                    setDrawHorizontalHighlightIndicator(false) // 水平线
                    setDrawVerticalHighlightIndicator(true) // 竖直线
                    enableDashedHighlightLine(10f, 10f, 0f) // 十字线样式
                }
            }
        }

        initLineDataSet(arrayOf(selfSet, contrastSet))
        selfSet.color = Color.BLACK
        contrastSet.color = Color.YELLOW

        chart_fund_trend.data = LineData(listOf(selfSet, contrastSet))
        chart_fund_trend.data.notifyDataChanged()
        chart_fund_trend.notifyDataSetChanged()
    }
}
