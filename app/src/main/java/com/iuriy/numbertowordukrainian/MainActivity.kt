package com.iuriy.numbertowordukrainian

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iuriy.numbertowordukrainian.ui.theme.NumberToWordUkrainianTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NumberToWordUkrainianTheme {
                Surface(
                    modifier = Modifier.fillMaxSize() ,
                    color = MaterialTheme.colors.background
                ) {
                    TextInput()
                }
            }
        }
    }
}

@Composable
fun Title(title: String) {
    Text(text = title, fontSize = 32.sp)
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun TextInput() {
    val focusManager = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(PaddingValues(top = 56.dp)))
        Title("123 to ??????")
        TextBar()
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun TextBar() {
    var textState by rememberSaveable() { mutableStateOf("0") }
    val maxChar = 15
    val focusManager = LocalFocusManager.current
    val ignoreSpecial = remember { Regex("^\\d+\$") }

    TextField(
        value = textState,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        onValueChange = {
            if (it.length < maxChar) {
                    textState = it
            }
        },
        maxLines = 1,
        label = { Text(text = "Ingrese un n??mero (15 d??gitos m??x.)") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done,
        ) ,
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }) ,
        trailingIcon = {
            IconButton(onClick = { textState = "0" }) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "??cono para borrar"
                )
            }
        },
    )
    if (!textState.isEmpty() && (textState.matches(Regex("^\\d+\$")))) {
        val num = textState.toLong()
        NumEnLetras(num)
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun NumEnLetras(numero: Long) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp , 20.dp),
        text = numero.toWords("uk", "UA"),
        maxLines = 10,
        fontSize = 20.sp,
        color = MaterialTheme.colors.primary
    )
}
