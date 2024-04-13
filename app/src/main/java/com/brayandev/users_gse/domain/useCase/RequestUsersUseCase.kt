package com.brayandev.users_gse.domain.useCase

import com.brayandev.users_gse.data.repository.UserRepository
import com.brayandev.users_gse.domain.model.UserItemModel
import javax.inject.Inject

class RequestUsersUseCase @Inject constructor(private val repository: UserRepository) {

    suspend fun invoke(): List<UserItemModel> {
        return repository.requestUsers()
    }
}
