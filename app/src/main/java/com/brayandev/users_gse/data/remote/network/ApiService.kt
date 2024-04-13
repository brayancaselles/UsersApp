package com.brayandev.users_gse.data.remote.network

import com.brayandev.users_gse.data.remote.model.UserItemResponse
import com.brayandev.users_gse.data.remote.model.UsersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<UsersResponse>

    @GET("users/{id}")
    suspend fun getDetailUser(@Path("id") id: Int): Response<UserItemResponse>
}
