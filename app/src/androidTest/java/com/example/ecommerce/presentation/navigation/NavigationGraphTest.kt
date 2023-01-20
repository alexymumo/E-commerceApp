package com.example.ecommerce.presentation.navigation

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.ecommerce.presentation.activity.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationGraphTest {

    @get:Rule
    val composeRule = createComposeRule()
    lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        composeRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            NavigationGraph(navController = navController)
        }
    }

    /*
    @Test
    fun verify_home_destination_is_home() {
        composeRule
            .onNodeWithTag("HomeScreen")
            .assertIsDisplayed()
    }

     */
}