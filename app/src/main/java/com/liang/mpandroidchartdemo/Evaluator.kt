package com.liang.mpandroidchartdemo

import kotlin.math.roundToInt

/**
 * created by zhangliang on 2018/7/26
 * profile: https://github.com/zhangliangnbu or zhangliangnbu@163.com
 */
object Evaluator {

    /**
     *
     */
    fun getIntegers(min:Float, max:Float, gapCount:Int) {

        val max = 1.3388
        val min = -0.451
        val count = 5

        var vMax = Math.ceil(max * 10).roundToInt()
        var vMin = Math.floor(min * 10).roundToInt()
        var delta = vMax - vMin
        println("vMax,vMin -> $vMax, $vMin" )
        var index = 1
        while (delta % (count - 1) != 0) {
            index ++
            if(index % 2 == 0) {
                vMax ++
            } else {
                vMin --
            }
            delta = vMax - vMin
            println("vMax,vMin -> $vMax, $vMin" )

            if(delta > 100) {
                break
            }
        }

        val gap = delta / (count -1)
        for(i in 0 until count) {
            println("$i -> ${(vMin + i * gap) * 10}")
        }
    }

    /**
     * rounds the given number to the next significant number
     *
     * @param number
     * @return
     */
    fun roundToNextSignificant(number: Double): Float {
        if (java.lang.Double.isInfinite(number) ||
                java.lang.Double.isNaN(number) ||
                number == 0.0)
            return 0f

        val d = Math.ceil(Math.log10(if (number < 0) -number else number).toFloat().toDouble()).toFloat()
        val pw = 1 - d.toInt()
        val magnitude = Math.pow(10.0, pw.toDouble()).toFloat()
        val shifted = Math.round(number * magnitude)
        return shifted / magnitude
    }
}