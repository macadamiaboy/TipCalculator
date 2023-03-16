package com.example.tipcalculator

import junit.framework.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalcTests {

    @Test
    fun testCalculateTip() {
        val bill = 200.0
        val tip = 15.0
        val roundUp = false
        val expectedTip = NumberFormat.getCurrencyInstance().format(30)
        val actualTip = calculateTip(bill, tip, roundUp)
        assertEquals(expectedTip, actualTip)
    }

}