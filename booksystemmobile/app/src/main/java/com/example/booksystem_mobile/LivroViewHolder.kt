package com.example.booksystem_mobile

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LivroViewHolder(view: View) : RecyclerView.ViewHolder(view)  {

    val  txtTitulo: TextView
    val txtAutor: TextView

    init {
        txtTitulo = view.findViewById(R.id.txtTitulo)
        txtAutor = view.findViewById(R.id.txtAutor)
    }

}