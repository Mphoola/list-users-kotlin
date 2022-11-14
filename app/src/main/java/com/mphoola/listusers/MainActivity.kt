package com.mphoola.listusers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.mphoola.listusers.ui.theme.ListUsersTheme
import com.mphoola.listusers.view.ErrorMessage
import com.mphoola.listusers.view.Filter
import com.mphoola.listusers.viewModel.UserViewModel

class MainActivity : ComponentActivity() {

    private val usersViewModel by viewModels<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListUsersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column() {
                        val textState = remember { mutableStateOf(TextFieldValue("")) }

                        Filter(state = textState)

                        if(usersViewModel.errorMessage.isNotEmpty()){
                            ErrorMessage(message = usersViewModel.errorMessage)
                        }else{

                        }

                        usersViewModel.getUsers()

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ListUsersTheme {
        Greeting("Android")
    }
}