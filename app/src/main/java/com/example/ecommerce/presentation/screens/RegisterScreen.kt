package com.example.ecommerce.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegisterScreen() {
    Column(
        //horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Register Account",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Fill Your Details Or Continue With",
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                overflow = TextOverflow.Clip,
                fontSize = 17.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Social Media",
                color = Color.Gray,
                overflow = TextOverflow.Clip,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

        //Spacer(modifier = Modifier.height(10.dp))

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Your Name",
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(20.dp))

        val value: String by remember {mutableStateOf("")}
        TextField(
            shape = MaterialTheme.shapes.medium,
            value = value,
            placeholder = {
                Text(text = "xxxxxxxx")
            },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            onValueChange = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Email Address",
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            shape = MaterialTheme.shapes.medium,
            value = value,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            placeholder = {
                Text(text = "xyz@gmail.com")
            },
            onValueChange = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Password",
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            shape = MaterialTheme.shapes.medium,
            value = value,
            placeholder = {
                Text(text = ".....")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            maxLines = 1,
            onValueChange = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = {},
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Transparent)
                .clip(shape = RoundedCornerShape(8.dp))
        ) {
            Text(
                text = "Sign Up",
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {},
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .clip(shape = RoundedCornerShape(8.dp))
        ) {
            Text(
                text = "Sign Up With Google",
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                buildAnnotatedString {
                    append("Already Have Account?")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                        append("Log In")
                    }
                },
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    RegisterScreen()
}