package com.example.ejercicio2.model

import retrofit2.Call
import retrofit2.http.GET


interface StudentApiService {

    @GET("estudent/estudent_list")
    fun getStudents(): Call<List<Student>>

}