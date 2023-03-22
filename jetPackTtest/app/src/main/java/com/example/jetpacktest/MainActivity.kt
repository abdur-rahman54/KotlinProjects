package com.example.jetpacktest

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.example.jetpacktest.ui.theme.JetpackTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Title()
            //Greeting(name = "Bella khan")
            MainContent()
        }
    }
}


//@Composable
//fun Title(){
//    val context = LocalContext.current
//    Text(
//        text = "First Jetpack Project",
//        fontSize = 24.sp,
//        fontFamily = FontFamily.Cursive,
//        color = colorResource(id = R.color.purple_700),
//        modifier = Modifier.clickable {
//            Toast.makeText(context, "Title Clicked", Toast.LENGTH_LONG).show()
//        }
//    )
//}

data class User( val id : Int)

@Composable
fun MainContent(){
    val user = User(1)
    val users = remember { mutableStateListOf(user) }
    Box(modifier = Modifier.fillMaxSize()) {
        UserList(users = users)
        Button(modifier = Modifier
            .padding(12.dp)
            .align(Alignment.BottomCenter), onClick = {
                users.add(User(1))
        }
        ) {
            Text(text = "Add More")
            
        }
    }
}


@Composable
fun UserList(users: List<User>){


//    val name = remember { mutableStateOf("Jhon")  }
//    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//        for (i in 1..10) {
//            UserCard()
//        }

    LazyColumn{
        items(users){ user ->
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
                .padding(0.dp)
                .border(1.dp, Color.Green)
                .padding(0.dp),


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
                //Text(text = stringResource(id = R.string.dummy_text))
                val context = LocalContext.current
                Button(onClick = {
                    //Perform Button click action here
                    Toast.makeText(context, "Profile is not Ready yet!!!", Toast.LENGTH_LONG).show()
                }) {
                    Text(text = "View Profile")
                }

            }
        }
    }



}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(modifier = Modifier.fillMaxSize()){
    MainContent()
    }
    //Title()
}

