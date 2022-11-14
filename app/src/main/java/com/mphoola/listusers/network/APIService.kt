package com.mphoola.listusers.network

import com.mphoola.listusers.model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIService {
    @Headers("x-apikey", "5c5c7076f210985199db5488")
    @GET("/")
    suspend fun  getUsers(): List<User>

    companion object {
        var apiService: APIService? = null
        fun getInstance() : APIService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://exercise-646d.restdb.io/rest/group-1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(APIService::class.java)
            }
            return apiService!!
        }
    }
}