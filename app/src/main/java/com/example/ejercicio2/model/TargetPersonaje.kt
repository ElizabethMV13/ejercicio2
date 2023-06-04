package com.example.ejercicio2.model

import com.google.gson.annotations.SerializedName

data class TargetPersonaje(
    @SerializedName("id")
    var id: String? = null,
    val name:String,
    val species:String,
    val gender:String,
    val house:String,
    val dateOfBirth:String,
    val yearOfBirth:Int,
    val wizard:Boolean,
    val ancestry:String,
    val eyeColour:String,
    val hairColour:String,
    val patronus:String,
    val hogwartsStudent: Boolean,
    val hogwartsStaff:Boolean,
    val actor:String,
    val alive: Boolean,
    val image: String
)