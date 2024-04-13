package com.brayandev.users_gse.domain.model

data class UserItemModel(
    val address: AddressModel,
    val company: CompanyModel,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String,
)
