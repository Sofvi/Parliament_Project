package com.suvilai.ex5.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.suvilai.ex5.data.ParliamentMembers
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

/**     Suvi Laitinen, 5.10.2022
 *      2113710
 *
 *      ApiService file
 */

private const val BASE_URL = "https://users.metropolia.fi/~peterh/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("seating.json")
    suspend fun getMemberList() : List<ParliamentMembers>

    //@GET("extras.json")
    //suspend fun getMemberDetailsList() : List<ParliamentMemberInfo>
}


val retrofitService : ApiService by lazy {
    retrofit.create(ApiService::class.java)
}
