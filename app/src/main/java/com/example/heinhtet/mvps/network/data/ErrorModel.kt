package com.example.heinhtet.mvps.network.data

import com.squareup.moshi.Json

/**
 * Created by heinhtet on 11/30/2017.
 */
data class ErrorModel(
        @Json(name = "error") val error: String? //invalid_credentials
)