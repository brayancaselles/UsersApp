package com.brayandev.users_gse.domain.model

data class AddressModel(
    val city: String,
    val geo: GeoModel,
    val street: String,
    val suite: String,
    val zipcode: String,
)
