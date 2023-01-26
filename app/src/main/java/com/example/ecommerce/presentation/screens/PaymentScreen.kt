package com.example.ecommerce.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecommerce.presentation.theme.EcommerceTheme

@Composable
fun PaymentScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
    }
}

@Preview
@Composable
fun PaymentScreenPreview() {
    EcommerceTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            PaymentScreen()
        }
    }
}