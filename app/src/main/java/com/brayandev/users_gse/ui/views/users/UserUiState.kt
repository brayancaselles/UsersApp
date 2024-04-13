package com.brayandev.users_gse.ui.views.users

import com.brayandev.users_gse.domain.model.UserItemModel

data class UserUiState(
    val isLoading: Boolean = false,
    val users: List<UserItemModel> = emptyList(),
)
