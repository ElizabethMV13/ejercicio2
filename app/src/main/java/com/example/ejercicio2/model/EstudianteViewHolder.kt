package com.example.ejercicio2.model
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicio2.R

class EstudianteViewHolder (view:View):RecyclerView.ViewHolder(view) {
    val name = view.findViewById<TextView>(R.id.item_nombre)
    val actor = view.findViewById<TextView>(R.id.item_actor)
    val img = view.findViewById<ImageView>(R.id.item_img)

    fun render(EstudinateModel: Student){
        name.text = EstudinateModel.nombre
        actor.text = EstudinateModel.actor
        Glide.with(img.context).load(EstudinateModel.image).into(img)
    }
}





