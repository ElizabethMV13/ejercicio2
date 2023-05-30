package com.example.ejercicio2.model

import retrofit2.Call
import retrofit2.http.GET

interface StaffApiService {
    @GET("api/characters/staff")
    fun getStaff(): Call<List<Staff>>
}