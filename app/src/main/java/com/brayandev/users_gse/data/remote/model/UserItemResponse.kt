package com.brayandev.users_gse.data.remote.model

import com.brayandev.users_gse.domain.model.UserItemModel

data class UserItemResponse(
    val address: AddressResponse,
    val company: CompanyResponse,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String,
)

fun UserItemResponse.toDomain() =
    UserItemModel(
        address = address.toDomain(),
        company = company.toDomain(),
        email = email,
        id = id,
        name = name,
        phone = phone,
        username = username,
        website = website,
    )
