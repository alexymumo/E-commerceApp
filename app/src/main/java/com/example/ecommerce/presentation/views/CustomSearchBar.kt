package com.example.ecommerce.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomSearchBar() {
    val value: String by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = value,
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp)),
            shape = MaterialTheme.shapes.medium,
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = {
                Text(
                    text = "Search...",
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            },
            onValueChange = {
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    tint = MaterialTheme.colors.onBackground,
                    contentDescription = "Search"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Clear,
                    tint = MaterialTheme.colors.onBackground,
                    contentDescription = null
                )
            }
        )

    }
}


@Preview
@Composable
fun SearchBarPreview() {
    CustomSearchBar()
}