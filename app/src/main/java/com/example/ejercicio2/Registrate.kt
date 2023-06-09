package com.example.ejercicio2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio2.databinding.ActivityLoginBinding
import com.example.ejercicio2.databinding.ActivityRegistrateBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException

class Registrate : AppCompatActivity() {

        private lateinit var firebaseAuth: FirebaseAuth
        private lateinit var binding: ActivityRegistrateBinding
        private var email = ""
        private var pass = ""

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityRegistrateBinding.inflate(layoutInflater)

            setContentView(binding.root)

            firebaseAuth = FirebaseAuth.getInstance()
            binding.buttonRegistrar.setOnClickListener{
                if(!validaCampos())return@setOnClickListener
                Log.d("error","mensahe-----------------------------------------" )

                crearUsuario(email, pass)
                startActivity(Intent(this,Login::class.java))
            }

            binding.buttonBack.setOnClickListener{
                startActivity(Intent(this,Login::class.java))
                finish()
            }


        }

    private fun crearUsuario(usr: String, pass: String){
        val auth = FirebaseAuth.getInstance()

        auth.createUserWithEmailAndPassword(usr, pass)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // El usuario se ha creado exitosamente
                    val user = auth.currentUser
                    Log.d("Firebase", "Usuario creado: ${user?.uid}")
                } else {
                    // Ocurrió un error al crear el usuario
                    Log.e("Firebase", "Error al crear el usuario: ${task.exception}")
                    var errores = manejaErrores(task)

                    val builder = AlertDialog.Builder(this)
                    builder.setTitle(R.string.errorl)
                        .setMessage(errores.toString())
                        .setPositiveButton(R.string.leyenda1) { dialog, _ ->
                            dialog.dismiss()
                        }

                    val dialog = builder.create()
                    dialog.show()
                }
            }

    }


    private fun manejaErrores(task: Task<AuthResult>){
        var errorCode =""
        var errorList = ""
        try {
            errorCode = (task.exception as FirebaseAuthException).errorCode
        }catch (e: Exception){
            errorCode= "NO_NETWORK"
        }

        when(errorCode){
            "ERROR_INVALID_EMAIL" ->{
                errorList = errorList + getString(R.string.errorl1) + " \n "
            }
            "ERROR_WRONG_PASSWORD" ->{
                errorList = errorList + getString(R.string.errorl2) + " \n "
            }
            "ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL" ->{
                errorList = errorList + getString(R.string.errorl3) + " \n "
            }
            "ERROR_EMAIL_ALREADY_IN_USE" ->{
                errorList = errorList + getString(R.string.errorl4) + " \n "
            }
            "NO_USE_TOKEN_EXPIRED" ->{
                errorList = errorList + getString(R.string.errorl5) + " \n "
            }
            "NO_USER_NOT_FOUND" ->{
                errorList = errorList + getString(R.string.errorl6) + " \n "
            }
            "NO_WEAK_PASSWORD" ->{
                errorList = errorList + getString(R.string.errorl71)+ " \n "
            }
            "NO_NETWORK" ->{
                errorList = errorList + getString(R.string.errorl8) + " \n "
            }
            else-> {
                errorList = errorList + getString(R.string.errorl9) + " \n "
            }
        }
    }


    private fun validaCampos():Boolean{
        email = binding.emailInputEditText.text.toString().trim()
        pass = binding.passInputEditText.text.toString().trim()
        val patron = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")

        Log.d("exitoso","$email-----------${email.isNotEmpty()}-----------${email.length}------------------onResponse {${pass}}---------${pass.isNotEmpty()}--- ${pass.length}")

        if(!patron.matches(email) || email.length == 0){
            Log.d("--------","email vacio")
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.errorl))
                .setMessage(getString(R.string.errorC))
                .setPositiveButton(R.string.leyenda1) { dialog, _ ->
                    dialog.dismiss()
                }
            val dialog = builder.create()
            dialog.show()
            return false
        }

        if(pass.length>=0 && pass.length < 6){
            Log.d("--------","pass con error")
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.errorl))
                .setMessage(getString(R.string.errorE))
                .setPositiveButton(R.string.leyenda1) { dialog, _ ->
                    dialog.dismiss()
                }
            val dialog = builder.create()
            dialog.show()
            return false
        }


        return true
    }
}