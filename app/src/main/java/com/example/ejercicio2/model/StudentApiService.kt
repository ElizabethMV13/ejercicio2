package com.example.ejercicio2.model

import retrofit2.Call
import retrofit2.http.GET

interface StudentApiService {
    @GET("api/characters/students")
    fun getStudents(): Call<List<Student>>
}