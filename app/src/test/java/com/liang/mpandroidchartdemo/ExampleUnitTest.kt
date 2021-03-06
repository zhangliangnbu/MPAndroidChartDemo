package com.liang.mpandroidchartdemo

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.roundToInt

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testEvaluation() {

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


}
