package com.brayandev.users_gse.data.remote

import android.util.Log
import com.brayandev.users_gse.data.remote.model.UserItemResponse
import com.brayandev.users_gse.data.remote.model.UsersResponse
import com.brayandev.users_gse.data.remote.network.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getUsersFromApi(): UsersResponse {
        var response = UsersResponse()
        runCatching { apiService.getUsers() }.onSuccess {
            if (it.isSuccessful && it.body() != null) response = it.body()!!
        }.onFailure {
            Log.d("RemoteDataSource", "Error getting users: ${it.message}")
        }
        return response
    }

    suspend fun getDetailUserFromApi(userId: Int): UserItemResponse? {
        var response: UserItemResponse? = null
        runCatching { apiService.getDetailUser(userId) }.onSuccess {
            if (it.isSuccessful && it.body() != null) response = it.body()!!
        }.onFailure {
            Log.d("RemoteDataSource", "Error getting item user: ${it.message}")
        }
        return response
    }
}
