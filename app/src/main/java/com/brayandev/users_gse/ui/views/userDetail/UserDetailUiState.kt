package com.brayandev.users_gse.ui.views.userDetail

import com.brayandev.users_gse.domain.model.UserItemModel

data class UserDetailUiState(
    val isLoading: Boolean = false,
    val user: UserItemModel? = null,
)
