package com.example.jetpacktest

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserCard()
        }
    }
}

@Composable
fun UserCard(){
    Card(
        elevation = 5.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .border(1.dp, Color.Green)
        ) {
            Image(
                painter = painterResource(id = R.drawable.jet),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(220.dp)
                    .padding(5.dp)
                    .fillMaxHeight()
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier
                    .offset(35.dp, 65.dp)
                    .padding(0.dp)
            ) {
                val context = LocalContext.current
                Button(onClick = {
                    Toast.makeText(context,
                    "Profile is not Ready yet!!!",
                    Toast.LENGTH_LONG)
                    .show()
                }
                ) {
                    Text(text = "View Profile")
                }
            }
        }
    }
}


