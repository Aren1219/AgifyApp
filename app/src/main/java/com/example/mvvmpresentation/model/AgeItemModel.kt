package com.example.mvvmpresentation.model


import com.google.gson.annotations.SerializedName

data class AgeItemModel(
    @SerializedName("age")
    val age: Int,
    @SerializedName("count")
    val count: Int,
    @SerializedName("country_id")
    val countryId: String,
    @SerializedName("name")
    val name: String
)