package com.liang.mpandroidchartdemo

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.utils.ViewPortHandler
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Philipp Jahoda on 14/09/15.
 */
class MyCustomXAxisValueFormatter(private val mViewPortHandler: ViewPortHandler) : IAxisValueFormatter {

    private val mFormat: DecimalFormat = DecimalFormat("###,###,###,##0.0")

    init {
        // maybe do something here or provide parameters in constructor
    }

    override fun getFormattedValue(value: Float, axis: AxisBase): String {


        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)
//        return if(value == axis.mEntries[0]) {
//            println("value->$value")
//            ""
//        } else {
//            sdf.format(Date(value.toLong()))
//        }
        return sdf.format(Date(value.toLong()))


        //Log.i("TRANS", "x: " + viewPortHandler.getTransX() + ", y: " + viewPortHandler.getTransY());

        // e.g. adjust the x-axis values depending on scale / zoom level
//        val xScale = mViewPortHandler.scaleX
//        return if (xScale > 5)
//            "4"
//        else if (xScale > 3)
//            "3"
//        else if (xScale > 1)
//            "2"
//        else
//            mFormat.format(value.toDouble())
    }
}
