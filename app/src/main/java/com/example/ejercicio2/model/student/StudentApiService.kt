package com.example.ejercicio2.model.student

import com.example.ejercicio2.model.TargetPersonaje
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface StudentApiService {
    @GET("api/characters/students")
    fun getStudents(): Call<ArrayList<Student>>

    //@GET("/api/character/{id}")
    @GET
    fun getTargerE(
       // @Path("id") id: String
        @Url url:String?
    ): Call<TargetPersonaje>

}