package com.example.ecommerce.presentation.views

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce.presentation.activity.MainActivity

@Composable
fun NoInternetItem(context: Context) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "No internet Connection. Please Check your connection",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            elevation = ButtonDefaults.elevation(20.dp),
            onClick = {
                val connectionManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val networkInfo: NetworkInfo? = connectionManager.activeNetworkInfo
                val isMobileConnected: Boolean = networkInfo?.isConnected == true
                if (isMobileConnected) {
                    (context as MainActivity).setContent {
                        //MainScreen()
                    }
                }
            }
        ) {
            Text(
                text = "Try Again"
            )
        }
    }

}

@Preview
@Composable
fun NoInternetItemPreview() {
    //NoInternetItem(context = context)
}