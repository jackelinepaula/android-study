package com.example.booksystem_mobile

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LivroViewHolder(view: View) : RecyclerView.ViewHolder(view)  {

    val  txtTitulo: TextView
    val txtAutor: TextView
    val btnExcluir : Button

    init {
        txtTitulo = view.findViewById(R.id.txtTitulo)
        txtAutor = view.findViewById(R.id.txtAutor)
        btnExcluir = view.findViewById(R.id.btnExcluir)
    }

}