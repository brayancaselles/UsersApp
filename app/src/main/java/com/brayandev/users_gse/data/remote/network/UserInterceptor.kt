package com.brayandev.users_gse.data.remote.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class UserInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request =
            chain.request().newBuilder().addHeader("Content-type", "application/json").build()
        return chain.proceed(request)
    }
}
