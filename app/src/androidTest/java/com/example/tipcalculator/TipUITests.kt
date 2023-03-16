package com.example.tipcalculator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testCalculateTip() {
        composeTestRule.setContent {
            TipCalculatorTheme() {
                Surface (modifier = Modifier.fillMaxSize()) {
                    TipTimeScreen()
                }
            }
        }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("200")
        composeTestRule.onNodeWithText("Tip (%)").performTextInput("15")
        val expectedTip = NumberFormat.getCurrencyInstance().format(30)
        composeTestRule.onNodeWithText("Tip amount $expectedTip").assertExists("No node with this text was found.")
    }
}