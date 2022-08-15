package com.example.mvvmpresentation.api

import com.example.mvvmpresentation.model.AgeItemModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiDetails {

    @GET("?")
    suspend fun getAge(
        @Query("name") name:String,
        @Query("country_id") country:String
    ): Response<AgeItemModel>

    @GET("?")
    suspend fun getAge(
        @Query("name") name:String
    ): Response<AgeItemModel>

    //@GET, @POST...
}