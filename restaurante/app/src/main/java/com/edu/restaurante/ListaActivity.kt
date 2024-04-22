package com.edu.restaurante

import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class ListaActivity: AppCompatActivity() {

    val lRestaurante = arrayListOf<Restaurante>();
    val gson = Gson()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.listaactivity_layout)

        //Pegando o listView
        val lView = findViewById<ListView>(R.id.lvRestaurantes)

        //Criando um arrayAdapter
        val arrAdap = ArrayAdapter(this, android.R.layout.simple_list_item_1, lRestaurante)

        //Atribuindo adapter no lview
        lView.adapter = arrAdap

        //Adicionando lista no adapter com uma função com retorno
        arrAdap.addAll(carregarPrefs())
    }

    fun carregarPrefs(): ArrayList<Restaurante> {
        val sp = getSharedPreferences("restaurantes", Context.MODE_PRIVATE)

        val restaurantes = sp.getString("Lista", "[]")

        val listaRestaurantes = gson.fromJson(restaurantes, ArrayList<Restaurante>()::class.java)

        return listaRestaurantes
    }
}