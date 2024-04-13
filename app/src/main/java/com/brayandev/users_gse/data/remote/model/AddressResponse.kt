package com.brayandev.users_gse.data.remote.model

import com.brayandev.users_gse.domain.model.AddressModel

data class AddressResponse(
    val city: String,
    val geo: GeoResponse,
    val street: String,
    val suite: String,
    val zipcode: String,
)

fun AddressResponse.toDomain() =
    AddressModel(
        city = city,
        geo = geo.toDomain(),
        street = street,
        suite = suite,
        zipcode = zipcode,
    )
