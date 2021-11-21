package com.electrics.watching

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.electrics.watching.ui.theme.WatchingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WatchingTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android", viewModel::searchShow)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, onClicked: (String) -> Unit) {
    Text(text = "Hello $name!", Modifier.clickable { onClicked.invoke("Avangers") })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WatchingTheme {
        Greeting("Android", { })
    }
}