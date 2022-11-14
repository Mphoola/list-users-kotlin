package com.mphoola.listusers.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mphoola.listusers.model.User
import com.mphoola.listusers.network.APIService
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

class UserViewModel: ViewModel() {
    var usersList : List<User> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getUsers(){
        viewModelScope.launch {
            val apiService = APIService.getInstance()

            try{
                val users = apiService.getUsers()

                usersList = users
            }catch (e: HttpException) {
                errorMessage = "Something went wrong"
            } catch (e: IOException) {
                errorMessage = "Please check your network connection"
            } catch(e: Exception){
//               errorMessage = e.message.toString()
                errorMessage = "Something went wrong"
            }
        }
    }

}