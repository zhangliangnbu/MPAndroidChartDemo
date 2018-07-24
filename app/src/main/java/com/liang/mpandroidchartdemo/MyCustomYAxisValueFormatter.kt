package com.liang.mpandroidchartdemo

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.utils.ViewPortHandler
import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Created by Philipp Jahoda on 14/09/15.
 */
class MyCustomYAxisValueFormatter(private val mViewPortHandler: ViewPortHandler) : IAxisValueFormatter {


    override fun getFormattedValue(value: Float, axis: AxisBase): String {

        val decimal = BigDecimal.valueOf(value.toDouble())
        return decimal.multiply(BigDecimal(100))
                .setScale(2, RoundingMode.HALF_EVEN)
                .toPlainString()
                .plus("%")
    }
}
