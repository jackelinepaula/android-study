package com.example.booksystem_mobile

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RecyclerViewAdapter(private val dataSet: Array<String>) :
    RecyclerView.Adapter<LivroViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): LivroViewHolder{

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.livro_layout, viewGroup, false)

        return LivroViewHolder(view);
    }

    override fun onBindViewHolder(viewHolder: LivroViewHolder, position: Int){
        viewHolder.txtTitulo.text = dataSet[position]
        viewHolder.txtAutor.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size



}