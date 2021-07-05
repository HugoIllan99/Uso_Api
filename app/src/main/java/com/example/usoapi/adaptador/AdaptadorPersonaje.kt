package com.example.usoapi.adaptador

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.usoapi.R
import com.example.usoapi.model.Personaje
import com.squareup.picasso.Picasso

class AdaptadorPersonaje(personajes:ArrayList<Personaje>, ctx:Context): RecyclerView.Adapter<AdaptadorPersonaje.ViewHolder>() {
    lateinit var personajes: ArrayList<Personaje>
    lateinit var ctx: Context

    init {
        this.ctx = ctx
        this.personajes = personajes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vistaPersonaje = LayoutInflater.from(ctx).inflate(R.layout.tarjeta_personaje,parent,false)
        val personajeViewHolder = ViewHolder(vistaPersonaje)
        vistaPersonaje.tag = personajeViewHolder
        return personajeViewHolder
    }

    override fun getItemCount(): Int {
        return personajes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNombre.text = personajes[position].nombre
        Picasso.get().load(personajes[position].imagen).into(holder.ivFoto)

    }

    class ViewHolder(vistaIndididual:View):RecyclerView.ViewHolder(vistaIndididual){
        lateinit var ivFoto:ImageView
        lateinit var tvNombre:TextView

        init {
            ivFoto = vistaIndididual.findViewById(R.id.ivAvatar)
            tvNombre = vistaIndididual.findViewById(R.id.tvNombre)
        }
    }
}