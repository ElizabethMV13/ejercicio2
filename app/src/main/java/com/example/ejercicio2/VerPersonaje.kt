package com.example.ejercicio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class VerPersonaje : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_personaje)
        val btn1: Button = findViewById(R.id.buttonBack)

        btn1.setOnClickListener{

            val  intent1: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent1)
        }
    }


}