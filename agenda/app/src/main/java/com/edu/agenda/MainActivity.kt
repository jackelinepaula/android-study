package com.edu.agenda

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    val lContatos = arrayListOf<Contato>()

    val gson = Gson()
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.mainactivity_layout)
        //Elementos
        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtTel = findViewById<EditText>(R.id.edtTelefone)

        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnPesquisar = findViewById<Button>(R.id.btnPesquisar)

        btnSalvar.setOnClickListener() {
            val contato = Contato(
                1,
                edtNome.text.toString(),
                edtEmail.text.toString(),
                edtTel.text.toString()
            )

            lContatos.add(contato)
            Log.i("ARRAYLIST", lContatos.toString())

            salvarPrefs(lContatos)
        }

        btnPesquisar.setOnClickListener {
            val obj = carregarPrefs(edtNome.text.toString())

            edtEmail.setText(obj.email)
            edtTel.setText(obj.telefone)

        }

    }

    fun salvarPrefs(array: ArrayList<Contato>) {
        val sp = this.getSharedPreferences("contatos", Context.MODE_PRIVATE)

        val obj = gson.toJson(array)

        with(sp.edit()) {
            putString("Lista", obj)
            apply()
        }


    }

    fun carregarPrefs(chave: String): Contato{
        val sp = this.getSharedPreferences("contatos", Context.MODE_PRIVATE)

        val json = sp.getString("Lista", "[]")

        val obj = gson.fromJson<ArrayList<Contato>>(json, object: TypeToken<ArrayList<Contato>>(){}.type)
        Log.i("OBJ", obj.toString())

        for (c in obj){
            if(chave == c.nome){
                return c
                Log.i("NOME", c.nome)
            }
        }

        val defC = Contato()

        return defC

    }

}

