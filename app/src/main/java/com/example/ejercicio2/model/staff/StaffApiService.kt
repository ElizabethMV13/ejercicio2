package com.example.ejercicio2.model.staff

import com.example.ejercicio2.model.TargetAdapter
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StaffApiService {
    @GET("api/characters/staff")
    fun getStaff(): Call<ArrayList<Staff>>

    @GET("api/characters/staff/{id}")
    fun getTargetS(
        @Path("id") id: String?
    ): Call<TargetAdapter>
}