package com.brayandev.users_gse.data.repository

import com.brayandev.users_gse.data.remote.RemoteDataSource
import com.brayandev.users_gse.data.remote.model.toDomain
import com.brayandev.users_gse.domain.model.UserItemModel
import javax.inject.Inject

class UserRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun requestUsers(): List<UserItemModel> {
        var userList = arrayListOf<UserItemModel>()
        remoteDataSource.getUsersFromApi().forEach { user -> userList.add(user.toDomain()) }
        return userList
    }

    suspend fun requestUserDetail(userId: Int): UserItemModel {
        return remoteDataSource.getDetailUserFromApi(userId)?.toDomain()!!
    }
}
