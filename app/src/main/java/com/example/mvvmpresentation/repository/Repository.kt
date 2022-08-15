package com.example.mvvmpresentation.repository

import com.example.mvvmpresentation.model.AgeItemModel
import retrofit2.Response

interface Repository {

    suspend fun getAge(
        name: String,
        country: String
    ): Response<AgeItemModel>

    suspend fun getAge(
        name: String
    ): Response<AgeItemModel>
}