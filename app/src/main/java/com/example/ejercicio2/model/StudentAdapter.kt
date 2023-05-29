package com.example.ejercicio2.model

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicio2.R

class StudentAdapter (var context : Context, private val listStudent:List<Student>):RecyclerView.Adapter<StudentAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nombre = itemView.findViewById<TextView>(R.id.textactor)
        val actor = itemView.findViewById<TextView>(R.id.textactor)
        val img = itemView.findViewById<ImageView>(R.id.item_img)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.item_personaje, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("exitoso ---------------","onResponse {${listStudent[position].actor}}")
        val estudiante = listStudent[position]
        Glide.with(context).load(estudiante.image).into(holder.img)
        holder.nombre.text = estudiante.name
        holder.actor.text = estudiante.actor

    }

    override fun getItemCount() = listStudent.count()





}