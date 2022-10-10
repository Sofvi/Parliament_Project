package com.suvilai.ex5.network

/**     Suvi Laitinen, 5.10.2022
 *      2113710
 *
 *      ImageApiService file. Fetches pictures of the members to details.
 */


object ImageApiService {
    private const val BASE_URL = "https://avoindata.eduskunta.fi"

    fun imageBuilder(imageId: String?): String? {
        if (imageId == null) {
            return null
        }
        return "$BASE_URL/$imageId"
    }
}

