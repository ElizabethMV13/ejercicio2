package com.example.ejercicio2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.ejercicio2.databinding.ActivityMainBinding
import com.example.ejercicio2.model.TargetAdapter
import com.example.ejercicio2.model.TargetPersonaje
import com.example.ejercicio2.model.staff.StaffApiService
import com.example.ejercicio2.model.student.StudentApiService
import com.example.ejercicio2.utils.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import kotlinx.coroutines.*
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.coroutineContext

class Details : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_details)





          val btn1: Button = findViewById(R.id.buttonBack)
          btn1.setOnClickListener{
             val intent1: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent1)
          }




          val fragment = intent.getIntExtra("fragment", 0)
          val id = intent.getStringExtra("id")

          Log.d("MainActivity", "Valor de fragment: $fragment   valor del id /api/character/${id}")


        val call = RetrofitService.getRetrofit().create(StudentApiService::class.java).getTargerE("api/character/${id}")



          call.enqueue(object : Callback<TargetPersonaje>{
            override fun onResponse(
                call: Call<TargetPersonaje>,
                response: Response<TargetPersonaje>
            ) {
                if (response.isSuccessful) {
                    val targetPersonaje = response.body()
                    Log.d("MainActivity", "Valor de targetPersonaje: $targetPersonaje")


                } else {
                    Log.d("MainActivity", "else $id")
                    val builder = AlertDialog.Builder(this@Details)
                    builder.setTitle(R.string.titleError2)
                        .setMessage(R.string.error2)
                        .setPositiveButton(R.string.leyenda1) { dialog, _ ->
                            dialog.dismiss()
                        }

                    val dialog = builder.create()
                    dialog.show()
                }
            }

            override fun onFailure(call: Call<TargetPersonaje>, t: Throwable) {
                val builder = AlertDialog.Builder(this@Details)
                builder.setTitle(R.string.titleError1)
                    .setMessage(R.string.error1)
                    .setPositiveButton(R.string.leyenda1) { dialog, _ ->
                        dialog.dismiss()
                    }

                val dialog = builder.create()
                dialog.show()

                Log.d("falla", "onFailure")
            }
        })



    }
}