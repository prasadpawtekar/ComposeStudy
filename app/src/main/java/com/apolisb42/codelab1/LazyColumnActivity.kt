package com.apolisb42.codelab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apolisb42.codelab1.ui.theme.CodeLab1Theme

class LazyColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeLab1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val list = List(100){"Player $it"}
                    Players(list = list)
                }
            }
        }
    }
}

@Composable
fun Players(modifier: Modifier= Modifier, list: List<String>) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = list) {
            GreetingCard(name = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    CodeLab1Theme {
        GreetingCard("Prasad")
    }
}

@Composable
fun GreetingCard(name: String, modifier: Modifier = Modifier) {

    val expanded = rememberSaveable {
        mutableStateOf(false)
    }

    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {

        Row(modifier = Modifier.padding(16.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {

                Text(
                    text = "Hello $name!",
                    modifier = modifier
                )
            }
            ElevatedButton(
                onClick = {
                    expanded.value = !expanded.value
                },
            ) {
                Text(text = if (expanded.value) "Show Less" else "Show More")
            }
        }
    }


}