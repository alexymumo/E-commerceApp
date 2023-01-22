package com.example.ecommerce.presentation.views

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce.R
import com.example.ecommerce.data.cache.entity.FavoriteEntity


@Composable
fun FavoriteItem() {
    Card(
        elevation = 20.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp).padding(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        ) {
            Card(
                elevation = 10.dp,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = "Roller Rabbit",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "men clothing",
                    fontSize = 16.sp,
                    color = Color.LightGray,
                    fontWeight = FontWeight.Medium
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = "$198.00",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(50.dp))
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                    ) {
                        Text(
                            text = "Add to cart",
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun FavoriteItemPreview() {
    FavoriteItem()
}