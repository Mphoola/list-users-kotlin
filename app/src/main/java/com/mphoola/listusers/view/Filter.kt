package com.mphoola.listusers.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Filter(state: MutableState<TextFieldValue>) {

    Row(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        TextField(
            value = state.value,
            onValueChange = {
                state.value = it
            },
            label = { Text(text = "Filter by city") },
            shape = RoundedCornerShape(26.dp),
            singleLine = true,
            modifier = Modifier
                .padding(4.dp)
                .weight(
                    1f
                ),
            textStyle = TextStyle(fontFamily = FontFamily.Monospace),
            leadingIcon = {
                Icon(imageVector = Icons.Filled.LocationOn, contentDescription = "location")
            },
            trailingIcon = {
                if (state.value.text.isNotEmpty()) {
                    IconButton(onClick = { state.value = TextFieldValue("") }) {
                        Icon(imageVector = Icons.Filled.Close, contentDescription = "clear")
                    }
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
        )

    }
}