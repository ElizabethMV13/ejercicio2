package com.example.ejercicio2.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicio2.R

class StudentAdapter (var context : Context, val listStudent:List<Student>):RecyclerView.Adapter<StudentAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nombre = itemView.findViewById<TextView>(R.id.item_nombre)
        val actor = itemView.findViewById<TextView>(R.id.item_actor)
        val img = itemView.findViewById<ImageView>(R.id.item_img)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view= LayoutInflater.from(context).inflate(R.layout.item_personaje, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(listStudent[position].image).into(holder.img)

        holder.nombre.text = listStudent[position].nombre
        holder.actor.text = listStudent[position].actor

    }

    override fun getItemCount(): Int {
        return listStudent.count()
    }




}