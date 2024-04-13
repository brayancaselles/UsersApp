package com.brayandev.users_gse.data.remote.model

import com.brayandev.users_gse.domain.model.GeoModel

data class GeoResponse(
    val lat: String,
    val lng: String,
)

fun GeoResponse.toDomain() = GeoModel(lat = lat, lng = lng)
