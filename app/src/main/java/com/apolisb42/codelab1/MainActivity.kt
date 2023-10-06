package com.apolisb42.codelab1

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apolisb42.codelab1.ui.theme.CodeLab1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeLab1Theme {
                // A surface container using the 'background' color from the theme
                /* Comment 1: Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }*/
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

fun showToast(context: Context, msg: String) {
    Toast
        .makeText(context, msg, Toast.LENGTH_SHORT)
        .show()

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val lContext = LocalContext.current

    val expanded = rememberSaveable {
        mutableStateOf(false)
    }

    val extraPadding = if(expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {

        Row(modifier = Modifier.padding(16.dp)) {
            Column (
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

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("Android", "World", "Compose", "Fun", "Parth", "Prasad", "Chaitali", "Aditi", "Devansh", "Krushnal", "Ganesh", "Arti", "Vidya", "Amol", "Bhalchandra")
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.verticalScroll(state = ScrollState(0), enabled = true)) {
            for (name in names) {
                Greeting(name)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CodeLab1Theme {
        MyApp(modifier = Modifier.fillMaxSize())
    }
}