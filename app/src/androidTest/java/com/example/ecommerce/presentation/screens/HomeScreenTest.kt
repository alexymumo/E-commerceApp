package com.example.ecommerce.presentation.screens

import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.Rule

class HomeScreenTest {


    @Rule
    var composeTestRule = createComposeRule()


    @Test
    fun test_home_is_displayed() {
        composeTestRule.setContent {
            composeTestRule.onNodeWithTag("HomeScreen")
        }
    }


}
