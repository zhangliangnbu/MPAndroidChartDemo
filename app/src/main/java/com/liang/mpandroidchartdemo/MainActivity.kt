package com.liang.mpandroidchartdemo

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initChart()

        updateChart(MockNetValueTrend().mockNormal())
    }

    private fun initChart() {
        with(chart_fund_trend) {
            // grid
            setDrawGridBackground(false)

            offsetLeftAndRight(100)

            // x axis
            xAxis.enableGridDashedLine(10f, 10f, 0f)
            xAxis.labelCount = 3
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.valueFormatter = IAxisValueFormatter { value, axis ->
                println("x axis -> $value, ${axis.mEntryCount}, ${axis.axisMaximum}")
                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)
                return@IAxisValueFormatter if(axis.mEntryCount > axis.labelCount && value == axis.axisMaximum){
                    ""
                } else {
                    sdf.format(Date((value * DAY_BY_MILLIS).toLong()))
                }
            }
            xAxis.setAvoidFirstLastClipping(true)

            // y axis
            axisLeft.removeAllLimitLines()
            axisLeft.enableGridDashedLine(10f, 10f, 0f)
//            axisLeft.labelCount = 5
            axisLeft.setLabelCount(5, true)
            axisLeft.setDrawAxisLine(false)
            axisLeft.valueFormatter = IAxisValueFormatter { value, axis ->
                val decimal = BigDecimal.valueOf(value.toDouble())
                return@IAxisValueFormatter decimal.multiply(BigDecimal(100))
                        .setScale(2, RoundingMode.HALF_EVEN)
                        .toPlainString()
                        .plus("%")
            }
            axisLeft.axisMaximum = 1.2f
            axisLeft.axisMinimum = -0.6f
            axisRight.isEnabled = false

            // other
            description.isEnabled = false
            setScaleEnabled(false)
            setTouchEnabled(true)
            legend.isEnabled = false

            // select
            setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
                override fun onNothingSelected() {
                }

                override fun onValueSelected(e: Entry?, h: Highlight?) {
                    if (e == null || h == null) {
                        return
                    }
                    println("x -> ${e.x.toBigDecimal().toPlainString()}")
                    val dataSet = chart_fund_trend.data.dataSets
                    val setIndex = h.dataSetIndex
                    val entryIndex = dataSet[setIndex].getEntryIndex(e)
                    if (entryIndex == -1) {
                        return
                    }
                    val sb = StringBuilder()
                    dataSet.forEachIndexed { i, set ->
                        if (set is LineDataSet) {
                            val entry = set.values[entryIndex]
                            val time = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(Date((entry.x * DAY_BY_MILLIS).toLong()))
                            sb.append("$time : ${entry.y} \n")
                        }
                    }
                    tv_desc.text = sb.toString()
                }
            })
        }
    }

    companion object {

        private const val DAY_BY_MILLIS = 24 * 3600 * 1000L
    }

    private fun updateChart(data: FundNetValueTrendModel) {
        // chart
        val yMin = data.minValuePoint.fundUnitValue.toFloat()
        val yMax = data.maxValuePoint.fundUnitValue.toFloat()


        val deltaY = yMax - yMin
        with(chart_fund_trend) {


        }

        // 数据
        fun parseEntries(origin:List<FundNetValueModel>): List<Entry>{
            return origin.mapIndexed { _, item ->
                val day = item.publishDay / DAY_BY_MILLIS
                return@mapIndexed Entry(day.toFloat(), item.riseAndFall?.toFloat() ?: 0f)
            }
        }
        val selfValues = parseEntries(data.latestData)
        val contrastValues = parseEntries(data.contrastData)
        val selfSet = LineDataSet(selfValues, "self data")
        val contrastSet = LineDataSet(contrastValues, "contrast data")

        // 样式
        fun initLineDataSet(sets: Array<LineDataSet>) {
            sets.forEach { set ->
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
