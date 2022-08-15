package com.example.mvvmpresentation.di

import com.example.mvvmpresentation.api.ApiDetails
import com.example.mvvmpresentation.api.ApiReference
import com.example.mvvmpresentation.api.ApiReference.BASE_URL
import com.example.mvvmpresentation.repository.Repository
import com.example.mvvmpresentation.repository.RepositoryImp
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
//set the lifetime for the dependencies, "SingletonComponent" -> app
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideApi(gson: Gson): ApiDetails{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiDetails::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api:ApiDetails): Repository = RepositoryImp(api)

//  to inject a interface instance, you need to create a abstract class module and use @Binds

//  to have multiple dependencies of the same type, use a qualifier: @Named("a name")
}