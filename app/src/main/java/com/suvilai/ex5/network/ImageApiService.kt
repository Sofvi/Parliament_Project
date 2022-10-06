package com.suvilai.ex5.network


object ImageApiService {
    private const val BASE_URL = "https://avoindata.eduskunta.fi"

    fun imageBuilder(imageId: String?): String? {
        if (imageId == null) {
            return null
        }
        return "$BASE_URL/$imageId"
    }
}

