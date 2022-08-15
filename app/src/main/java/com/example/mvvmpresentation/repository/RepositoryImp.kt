package com.example.mvvmpresentation.repository

import com.example.mvvmpresentation.api.ApiDetails
import com.example.mvvmpresentation.model.AgeItemModel
import retrofit2.Response
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val apiDetails: ApiDetails): Repository {

    override suspend fun getAge(
        name: String,
        country: String
    ): Response<AgeItemModel> = apiDetails.getAge(name, country)

    override suspend fun getAge(
        name: String
    ): Response<AgeItemModel> = apiDetails.getAge(name)
}