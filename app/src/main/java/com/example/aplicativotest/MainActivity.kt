package com.example.aplicativotest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aplicativotest.ui.theme.AplicativotestTheme
import kotlin.random.Random
import androidx.compose.material3.Surface as Surface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplicativotestTheme {
                @Composable
                fun extracted1() {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        MainScreen(

                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }

                extracted1()
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf("Thoughts")  }
    val list = stringArrayResource(R.array.quotes)
    Surface(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(R.drawable.fundo),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.padding(30.dp)
            ) {

                Text(
                    text = result,
                    color = Color.Black,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(20.dp)
                )
            }
            Button(onClick = {
                val indice = Random.nextInt(list.size)
                result = list[indice]
            } ) {
                Text("New Quote")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    AplicativotestTheme {
        MainScreen()
    }
}