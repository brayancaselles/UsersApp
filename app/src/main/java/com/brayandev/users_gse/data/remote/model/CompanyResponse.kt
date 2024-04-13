package com.brayandev.users_gse.data.remote.model

import com.brayandev.users_gse.domain.model.CompanyModel

data class CompanyResponse(
    val bs: String,
    val catchPhrase: String,
    val name: String,
)

fun CompanyResponse.toDomain() = CompanyModel(bs = bs, catchPhrase = catchPhrase, name = name)
