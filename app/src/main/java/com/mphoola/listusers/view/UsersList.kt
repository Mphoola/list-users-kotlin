package com.mphoola.listusers.view

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import com.mphoola.listusers.model.User
import java.util.*

@Composable
fun UsersList(list: List<User>, state: MutableState<TextFieldValue>) {
    var selectedIndex by remember { mutableStateOf(-1) }
    val context = LocalContext.current


    LazyColumn {
        val filterText = state.value.text

        val usersList: List<User> = if (filterText.isEmpty()) {
            list
        } else {
            val resultList = ArrayList<User>()

            for (mov in list) {
                if (mov.CITY.lowercase(Locale.getDefault()).contains(filterText.lowercase())) {
                    resultList.add(mov)
                }
            }

            resultList
        }

        if (filterText.isNotEmpty() && usersList.isEmpty()){
            Toast.makeText(context, "No results found", Toast.LENGTH_SHORT).show()
        }

        itemsIndexed(items = usersList) { index, item ->
            UserItem(user = item, index, selectedIndex) { i ->
                selectedIndex = i
            }
        }
    }

}