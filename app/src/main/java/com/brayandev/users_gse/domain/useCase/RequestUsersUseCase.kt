package com.brayandev.users_gse.domain.useCase

import com.brayandev.users_gse.data.repository.UserRepository
import javax.inject.Inject

class RequestUsersUseCase @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke() = repository.requestUsers()
}
