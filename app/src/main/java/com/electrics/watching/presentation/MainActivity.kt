package com.electrics.watching.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.electrics.watching.presentation.theme.WatchingTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WatchingTheme {
                // A surface container using the 'background' color from the theme
                val scaffoldState = rememberScaffoldState()
                LaunchedEffect(key1 = viewModel) {
                    viewModel.error.collect { message ->
                        scaffoldState.snackbarHostState.showSnackbar(message = message)
                    }
                }

                Scaffold(
                    scaffoldState = scaffoldState,
                    backgroundColor = MaterialTheme.colors.background,
                    snackbarHost = {
                        SnackbarHost(hostState = it) { data ->
                            Snackbar(
                                snackbarData = data,
                                backgroundColor = MaterialTheme.colors.primary
                            )
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column {
                            Greeting("Search", viewModel::searchShow)
                            Greeting2("Schedule", viewModel::getSchedule)
                        }
                        if (viewModel.isLoading.value) {
                            CircularProgressIndicator(
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, onClicked: (String) -> Unit) {
    Text(text = "Hello $name!", Modifier.clickable { onClicked.invoke("Avangers") })
}

@Composable
fun Greeting2(name: String, onClicked: () -> Unit) {
    Text(text = "Hello $name!", Modifier.clickable(onClick = onClicked))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WatchingTheme {
        Greeting("Android", { })
    }
}