package com.example.booksystem_mobile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RecyclerViewAdapter(private val dataSet: ArrayList<Livro>) :
    RecyclerView.Adapter<LivroViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): LivroViewHolder{

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.livro_layout, viewGroup, false)

        return LivroViewHolder(view);
    }

    override fun onBindViewHolder(viewHolder: LivroViewHolder, position: Int){
        viewHolder.txtTitulo.text = dataSet[position].titulo
        viewHolder.txtAutor.text = dataSet[position].autor
    }

    override fun getItemCount() = dataSet.size

}