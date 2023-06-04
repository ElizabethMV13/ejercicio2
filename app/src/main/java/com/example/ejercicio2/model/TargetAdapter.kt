package com.example.ejercicio2.model

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicio2.R

class TargetAdapter (var context : Context, private val listTarget:List<TargetPersonaje>):RecyclerView.Adapter<TargetAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre = itemView.findViewById<TextView>(R.id.item_name)
        val actor = itemView.findViewById<TextView>(R.id.item_actor)
        val house = itemView.findViewById<TextView>(R.id.item_house)
        val genero = itemView.findViewById<TextView>(R.id.item_genero)
        val especie = itemView.findViewById<TextView>(R.id.item_especie)
        val patronus = itemView.findViewById<TextView>(R.id.item_patronus)
        val nucleo = itemView.findViewById<TextView>(R.id.item_nucleo)
        val madera = itemView.findViewById<TextView>(R.id.item_madera)
        val longitud = itemView.findViewById<TextView>(R.id.item_longitud)
        val img = itemView.findViewById<ImageView>(R.id.item_img)
        val cardView = itemView.findViewById<CardView>(R.id.card_personaje)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.activity_details, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = listTarget.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val estudiante = listTarget[position]
        Log.d("MainActivity", "--------------- $holder   --------------------- $position ")

        if (estudiante.image == "") {
            holder.img.setImageResource(R.drawable.sunfoto)
        } else {
            Glide.with(context).load(estudiante.image).into(holder.img)
        }

        if (estudiante.name == "") {
            holder.nombre.text = context.getString(R.string.sinestudiante)
        } else {
            holder.nombre.text = estudiante.name
        }


        if (estudiante.actor == "") {
            holder.actor.text = context.getString(R.string.sinactor)
        } else {
            holder.actor.text = estudiante.actor
        }

        val datoHouse = estudiante.house

        when (datoHouse) {
            "Slytherin" -> {
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.card_s))
                holder.house.text = estudiante.house
            }
            "Gryffindor" -> {
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.card_g))
                holder.house.text = estudiante.house
            }
            "Hufflepuff" -> {
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.card_h))
                holder.house.text = estudiante.house
            }
            "Ravenclaw" -> {
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.card_r))
                holder.house.text = estudiante.house
            }
            else -> {
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.card))
                holder.house.text = context.getString(R.string.sinhouse)
            }

        }
    }


}

