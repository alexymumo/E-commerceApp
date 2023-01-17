package com.example.ecommerce.presentation.views

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce.R


@Composable
fun FavoriteItem() {
    Card(
        elevation = 20.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(5.dp)
        ) {
            Icon(
                Icons.Filled.Favorite,
                tint = Color.Cyan,
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = "Nike Jordan",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "$34.90",
                fontSize = 16.sp
            )
        }
    }

}

@Preview
@Composable
fun FavoriteItemPreview() {
    FavoriteItem()
}