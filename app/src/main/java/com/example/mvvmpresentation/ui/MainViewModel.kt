package com.example.mvvmpresentation.ui

import android.app.Application
import android.media.AsyncPlayer
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmpresentation.model.AgeItemModel
import com.example.mvvmpresentation.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository:Repository
): ViewModel() {

    private lateinit var response: Response<AgeItemModel>
    var myAge: String? = ""
    var myName: String? = ""
    var myCount: String? = ""

    suspend fun getAge(name: String) {

        try {
            response = repository.getAge(name)
        } catch(e: Exception) {
            myAge = null
            myName = null
            myCount = null
            return
        }

        if (response.isSuccessful) {
            myAge = response.body()?.age.toString()
            myName = response.body()?.name.toString()
            myCount = response.body()?.count.toString()
        } else {
            when (response.code()) {
                422 -> {}
                429 -> {}
                else -> {}
                //make a toast or something
            }
        }

    }
}