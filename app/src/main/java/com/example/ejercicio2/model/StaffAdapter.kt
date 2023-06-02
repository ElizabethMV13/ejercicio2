package com.example.ejercicio2.model

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicio2.R

class StaffAdapter (var context : Context, private val listStaff:List<Staff>, val listener: StaffAdapter.ClickListener): RecyclerView.Adapter<StaffAdapter.ViewHolder>() {

    var onItemOnClick: ((Staff) ->Unit)? = null

    interface ClickListener{
        fun onClick(position: Int)
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nombre = itemView.findViewById<TextView>(R.id.item_name)
        val actor = itemView.findViewById<TextView>(R.id.item_actor)
        val house = itemView.findViewById<TextView>(R.id.item_house)
        val img = itemView.findViewById<ImageView>(R.id.item_img)
        val cardView =  itemView.findViewById<CardView>(R.id.card_personaje)

        init {
            itemView.setOnClickListener { v: View->
                val position: Int = absoluteAdapterPosition
                listener.onClick(position)
            }
        }

        private fun ViewHolderResumen(position: Int) {

            Log.d("en ViewHolderResumen ---------------", "onResponse {${listStaff[position].house}}")

            val viewResumen = LayoutInflater.from(context).inflate(R.layout.activity_ver_personaje, null)

            val nombre = viewResumen.findViewById<TextView>(R.id.item_name)
            val actor = viewResumen.findViewById<TextView>(R.id.item_actor)
            val house = viewResumen.findViewById<TextView>(R.id.item_house)
            val genero = viewResumen.findViewById<TextView>(R.id.item_genero)
            val especie = viewResumen.findViewById<TextView>(R.id.item_especie)
            val patronus = viewResumen.findViewById<TextView>(R.id.item_patronus)
            val nucleo = viewResumen.findViewById<TextView>(R.id.item_nucleo)
            val madera = viewResumen.findViewById<TextView>(R.id.item_madera)
            val longitud = viewResumen.findViewById<TextView>(R.id.item_longitud)
            val img = viewResumen.findViewById<ImageView>(R.id.item_img)
            val cardView = viewResumen.findViewById<CardView>(R.id.card_personaje)

            val estudiante = listStaff[position]

            if (estudiante.image == "") {
                img.setImageResource(R.drawable.sunfoto)
            } else {
                Glide.with(context).load(estudiante.image).into(img)
            }

            if (estudiante.name == "") {
                nombre.text = context.getString(R.string.sinestudiante)
            } else {
                nombre.text = estudiante.name
            }


            if (estudiante.actor == "") {
                actor.text = context.getString(R.string.sinactor)
            } else {
                actor.text = estudiante.actor
            }

            val datoHouse = estudiante.house

            when (datoHouse) {
                "Slytherin" -> {
                    cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.card_s))
                    house.text = estudiante.house
                }
                "Gryffindor" -> {
                    cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.card_g))
                    house.text = estudiante.house
                }
                "Hufflepuff" -> {
                    cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.card_h))
                    house.text = estudiante.house
                }
                "Ravenclaw" -> {
                    cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.card_r))
                    house.text = estudiante.house
                }
                else -> {
                    cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.card))
                    house.text = context.getString(R.string.sinhouse)
                }

            }



        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.item_personaje, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = listStaff.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val estudiante = listStaff[position]

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